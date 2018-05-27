package mr.master.levrigtech.data

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Single
import mr.master.levrigtech.Member

/**
 * @author Deyine Jiddou (deyine.jiddou@gmail.com)
 * Created at 5/27/18
 */
@Dao
interface MemberDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(members: List<Member>)

    @Query("select * from members")
    fun getAll() : Single<List<Member>>
}