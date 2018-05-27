package mr.master.levrigtech

import android.app.Application
import android.arch.persistence.room.Room
import mr.master.levrigtech.data.AppDatabase

/**
 * @author Deyine Jiddou (deyine.jiddou@gmail.com)
 * Created at 5/27/18
 */
class LevrigApplication : Application() {


    companion object {
        lateinit var appInstance: LevrigApplication
    }

    var appDatabase: AppDatabase? = null

    override fun onCreate() {
        super.onCreate()
        appInstance = this
        appDatabase = Room
                .databaseBuilder(applicationContext, AppDatabase::class.java, "levrig-db")
                .build()
    }
}