package com.example.contact.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contact.Model.User
import com.example.contact.ProfileActivity
import com.example.contact.R

class UserAdapter: RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    //local database
    private var userList = emptyList<User>()

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var phonenumber: TextView

        init {
            name = itemView.findViewById(R.id.name)
            phonenumber = itemView.findViewById(R.id.phonenumber)

            itemView.setOnClickListener {
                val position: Int = adapterPosition
                val context = itemView.context
                val intent = Intent(context, ProfileActivity::class.java).apply {
                    putExtra("ID", position)
                    putExtra("NAME", name.text)
                    putExtra("PHONENUMBER", phonenumber.text)
                }
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.user,parent,false)
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentUser = userList[position]
        holder.name.text = currentUser.username
        holder.phonenumber.text = currentUser.phonenumber
    }

    override fun getItemCount() = userList.size

    fun setData(user: List<User>){
        this.userList = user
        notifyDataSetChanged()
    }

}