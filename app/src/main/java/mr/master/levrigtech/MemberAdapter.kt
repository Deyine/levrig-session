package mr.master.levrigtech

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.signature.ObjectKey

/**
 * @author Deyine Jiddou (deyine.jiddou@gmail.com)
 * Created at 5/27/18
 */
class MemberAdapter (var context: Context?, var members: List<Member>) : RecyclerView.Adapter<MemberAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.member_item, parent, false)

        val vh = ViewHolder(v)
        return vh
    }

    override fun getItemCount(): Int {
        return members.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val m = members[position]

        holder?.name?.text = m.name
        holder?.phone?.text = m.phone
        Glide.with(context)
                .load(m.ppUrl)
                .apply(RequestOptions().signature(ObjectKey(System.currentTimeMillis())))
                .into(holder?.profilePicture)

    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        var profilePicture: ImageView? = null
        var phone: TextView? = null
        var name: TextView? = null

        init {
            profilePicture = v.findViewById(R.id.member_pp) as ImageView
            phone = v.findViewById(R.id.member_phone) as TextView
            name = v.findViewById(R.id.member_name) as TextView
        }
    }

}