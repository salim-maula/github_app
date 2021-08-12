package com.salim.githubuserv1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class UserAdapter internal constructor(private val context: Context) : BaseAdapter() {
    internal var user = arrayListOf<User>()

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
        var itemView = view
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_user, viewGroup, false)
        }
        val viewHolder = ViewHolder(itemView as View)
        val hero = getItem(position) as User
        viewHolder.bind(hero)
        return itemView
    }

    override fun getItem(i: Int): Any {
        return user[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getCount(): Int {
        return user.size
    }

    private inner class ViewHolder internal constructor(view: View) {
        private val txtName: TextView = view.findViewById(R.id.txt_name)
        private val txtUsername: TextView = view.findViewById(R.id.txt_username)
        private val imgPhoto: CircleImageView = view.findViewById(R.id.circleImageView)
        internal fun bind(user: User) {
            txtName.text = user.name
            txtUsername.text = user.username
            imgPhoto.setImageResource(user.photo)
        }
    }

}
