package com.reyhan.getdataapi.second

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.reyhan.getdataapi.databinding.ItemThirdBinding
import com.reyhan.getdataapi.first.data.UsersItem
import com.reyhan.getdataapi.second.datas.UsersResponseItem

class JsonAdapter : RecyclerView.Adapter<JsonAdapter.JsonViewHolder>() {

    private val listJson = arrayListOf<UsersResponseItem>()

    class JsonViewHolder (val itemJson: ItemThirdBinding):
        RecyclerView.ViewHolder(itemJson.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = JsonViewHolder(
        ItemThirdBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: JsonViewHolder, position: Int) {
        holder.itemJson.apply {
            with(listJson[position]){
                tvThird.text = name
                tvEmail.text = email
            }
        }
    }

    override fun getItemCount() = listJson.size

    fun setEmail(email: ArrayList<UsersResponseItem>){
        this.listJson.clear()
        this.listJson.addAll(email)
    }
}