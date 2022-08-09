package com.reyhan.getdataapi.first.data

import com.google.gson.annotations.SerializedName

data class Users(

	@field:SerializedName("UsersItem")
	val usersItem: List<UsersItem?>? = null
)