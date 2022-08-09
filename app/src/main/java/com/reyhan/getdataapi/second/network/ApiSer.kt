package com.reyhan.getdataapi.second.network

import com.reyhan.getdataapi.second.datas.UsersResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiSer {
    @GET("users")
    fun getUser() : Call<ArrayList<UsersResponseItem>>
}