package mr.master.levrigtech.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import mr.master.levrigtech.Member

/**
 * @author Deyine Jiddou (deyine.jiddou@gmail.com)
 * Created at 5/27/18
 */

@Database(entities = [Member::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun memberDao() : MemberDao
}