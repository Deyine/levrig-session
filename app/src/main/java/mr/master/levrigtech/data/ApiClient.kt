package mr.master.levrigtech.data

import com.google.gson.GsonBuilder
import io.reactivex.Observable
import mr.master.levrigtech.Member
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * @author Deyine Jiddou (deyine.jiddou@gmail.com)
 * Created at 5/27/18
 */
interface ApiClient {


    companion object {
        val RETROFIT = Retrofit.Builder()
                .baseUrl("http://192.168.3.176:3000/")
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        val ApiClientImpl = RETROFIT.create(ApiClient::class.java)
    }

    /**
     * get list of members from API
     */
    @GET("members")
    fun getMembers(): Observable<List<Member>>

}