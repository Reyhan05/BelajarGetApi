package com.reyhan.getdataapi.second

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.reyhan.getdataapi.databinding.ItemSecondBinding
import com.reyhan.getdataapi.second.datas.UsersResponseItem

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private val listUser = ArrayList<UsersResponseItem>()

    class UserViewHolder(val itemUser: ItemSecondBinding) :
        RecyclerView.ViewHolder(itemUser.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserViewHolder(
        ItemSecondBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.itemUser.apply {
            with(listUser[position]){
                tvName.text = name
                tvUsername.text = username
                tvEmail.text = email
            }
        }
    }

    override fun getItemCount() = listUser.size

    fun setUser(users: ArrayList<UsersResponseItem>){
        this.listUser.clear()
        this.listUser.addAll(users)
    }
}