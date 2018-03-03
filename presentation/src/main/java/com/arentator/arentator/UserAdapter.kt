package com.arentator.arentator

import android.content.Context
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.user_item.view.*

/**
 * Created by Nikolay on 03.03.2018.
 */
class UserAdapter(
        val listener: (user: UserModel, sharedView: View) -> Unit
) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private var users: MutableList<UserModel> = mutableListOf()
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.user_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users[position]
        holder.let {
            val username = "${user.firstName} ${user.lastName}"
            it.username.text = username
            user.avatar?.let {
                Glide.with(context)
                        .load(it)
                        .into(holder.avatar)
            }

            it.root.setOnClickListener {
                listener.invoke(user, it.avatar)
            }
        }
    }

    fun addUsers(users: MutableList<UserModel>) {
        val lastPosition = users.size
        this.users.addAll(users)
        notifyItemRangeChanged(lastPosition, this.users.size)
    }

    override fun getItemCount() = users.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val username: AppCompatTextView = view.username
        val avatar: CircleImageView = view.avatar
        val root: CardView = view.root
    }
}