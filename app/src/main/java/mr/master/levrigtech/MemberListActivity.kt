package mr.master.levrigtech

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_member_list.*
import mr.master.levrigtech.data.ApiClient

class MemberListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_member_list)

        memberList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        ApiClient.ApiClientImpl.getMembers()
                .doOnNext({
                    LevrigApplication.appInstance.appDatabase?.memberDao()?.insertAll(it)
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    result -> run {
                        memberList.adapter = MemberAdapter(this, result)
                    }
                }, {
                    error -> run {
                        getFromDB()
                    }
                })



    }

    private fun getFromDB() {
        LevrigApplication.appInstance.appDatabase?.memberDao()?.getAll()
                ?.toObservable()
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe( {
                    result -> run {
                    memberList.adapter = MemberAdapter(this, result)
                }
                }, {
                    error -> run {
                    Toast.makeText(this, "Erreur d acces BD", Toast.LENGTH_LONG).show()
                }
                })

    }
}
