package com.reyhan.getdataapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.reyhan.getdataapi.first.data.UsersItem
import com.reyhan.getdataapi.databinding.ActivityMainBinding
import com.reyhan.getdataapi.first.AdapterUsers
import com.reyhan.getdataapi.first.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    private val adapterUsers = AdapterUsers()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // getApi
        getDataApi()

    }

    fun setData(data: ArrayList<UsersItem>) {
        // set layout manager and adapter
        binding.rvList.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = adapterUsers
            adapterUsers.setUsers(data)
        }
    }

    fun getDataApi() {
        ApiConfig.getApiService().getListUser().enqueue(object : Callback<ArrayList<UsersItem>> {
            override fun onResponse(
                call: Call<ArrayList<UsersItem>>,
                response: Response<ArrayList<UsersItem>>
            ) {
                response.body()?.let {
//                    adapterUsers.setUsers(it)
                    setData(it)
                }
            }

            override fun onFailure(call: Call<ArrayList<UsersItem>>, t: Throwable) {
                Log.e("TAG", "onFailure: $t")
            }

        })
    }
}