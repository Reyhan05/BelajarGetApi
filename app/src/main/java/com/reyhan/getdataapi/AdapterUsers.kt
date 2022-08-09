package com.reyhan.getdataapi

import android.media.Image
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.reyhan.getdataapi.data.UsersItem
import com.reyhan.getdataapi.databinding.ItemUsersBinding

class AdapterUsers : RecyclerView.Adapter<AdapterUsers.UserViewHolder>() {

    private val listUser = ArrayList<UsersItem>()

    class UserViewHolder(val itemUsers: ItemUsersBinding) :
        RecyclerView.ViewHolder(itemUsers.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserViewHolder(
        ItemUsersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.itemUsers.apply {
            with(listUser[position]){
                TextView.text = login
                Glide.with(imageView.context).load(avatarUrl).into(imageView)
            }
        }
    }

    override fun getItemCount() = listUser.size

    fun setUsers(user: ArrayList<UsersItem>){
        this.listUser.clear()
        this.listUser.addAll(user)
    }

}