package com.reyhan.getdataapi.second

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.reyhan.getdataapi.databinding.ActivitySecondBinding
import com.reyhan.getdataapi.second.datas.UsersResponseItem
import com.reyhan.getdataapi.second.network.ApiCon
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SecondActivity : AppCompatActivity() {

    private var _binding : ActivitySecondBinding? = null
    private val binding get() = _binding as ActivitySecondBinding

    private val userAdapter = UserAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // getDataApi
        getApi()
    }

    fun setDatas(datas: ArrayList<UsersResponseItem>){
        binding.rvSecond.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = userAdapter
            userAdapter.setUser(datas)
        }
    }

    private fun getApi() {
        ApiCon.getApiService().getUser().enqueue(object : Callback<ArrayList<UsersResponseItem>>{
            override fun onResponse(
                call: Call<ArrayList<UsersResponseItem>>,
                response: Response<ArrayList<UsersResponseItem>>
            ) {
                response.body()?.let {
                    setDatas(it)
                }
            }

            override fun onFailure(call: Call<ArrayList<UsersResponseItem>>, t: Throwable) {
                Log.e("TAG", "onFailure: $t")
            }

        })
    }
}