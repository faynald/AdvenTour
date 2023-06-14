package com.c23pr591.adventour.core.data.network.response

import com.google.gson.annotations.SerializedName

data class SignUpResponse(

	@field:SerializedName("data")
	val signUpItemResponse: SignUpItemResponse? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class SignUpItemResponse(

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("umur")
	val umur: Int? = null,

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("pengalaman")
	val pengalaman: Int? = null,

	@field:SerializedName("jenisKelamin")
	val jenisKelamin: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("domisili")
	val domisili: String? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null
)
