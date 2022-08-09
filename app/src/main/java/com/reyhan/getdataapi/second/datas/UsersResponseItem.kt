package com.reyhan.getdataapi.second.datas

import com.google.gson.annotations.SerializedName

data class UsersResponseItem(

	@field:SerializedName("website")
	val website: String? = null,

	@field:SerializedName("phone")
	val phone: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("username")
	val username: String? = null
)