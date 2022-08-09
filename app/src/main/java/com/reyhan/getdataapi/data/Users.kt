package com.reyhan.getdataapi.data

import com.google.gson.annotations.SerializedName

data class Users(

	@field:SerializedName("UsersItem")
	val usersItem: List<UsersItem?>? = null
)