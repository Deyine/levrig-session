package mr.master.levrigtech

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * @author Deyine Jiddou (deyine.jiddou@gmail.com)
 * Created at 5/27/18
 */
@Entity(tableName = "members")
data class Member (
        @PrimaryKey
        @ColumnInfo(name = "id")
        @SerializedName("id")
        var id: Long?,
        @ColumnInfo(name = "name")
        @SerializedName("name")
        var name: String?,
        @ColumnInfo(name = "phone")
        @SerializedName("phone")
        var phone: String?,
        @ColumnInfo(name = "url")
        @SerializedName("url")
        var ppUrl: String
)