package com.reyhan.getdataapi.network

import retrofit2.Call
import com.reyhan.getdataapi.data.UsersItem
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiServices {
    @GET("users")
    @Headers("Authorization: token-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")
    fun getListUser() : Call<ArrayList<UsersItem>>
}