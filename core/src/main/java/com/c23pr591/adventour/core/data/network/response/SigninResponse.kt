package com.c23pr591.adventour.core.data.network.response

import com.google.gson.annotations.SerializedName

data class SigninResponse(

	@field:SerializedName("data")
	val data: String? = null,

	@field:SerializedName("message")
	val message: String? = null
)
