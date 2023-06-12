package com.c23pr591.adventour.core.data.network.request

import com.google.gson.annotations.SerializedName

data class SignupRequest(
    @field:SerializedName("nama")
    val name: String,

    @field:SerializedName("jenisKelamin")
    val gender: String,

    @field:SerializedName("umur")
    val age: Int,

    @field:SerializedName("domisili")
    val domicile: String,

    @field:SerializedName("pengalaman")
    val experience: Int,

    @field:SerializedName("email")
    val email: String,

    @field:SerializedName("password")
    val password: String,

    @field:SerializedName("confirmPassword")
    val confirmPassword: String
)
