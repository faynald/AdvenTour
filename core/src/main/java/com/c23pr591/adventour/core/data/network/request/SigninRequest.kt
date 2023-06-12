package com.c23pr591.adventour.core.data.network.request

import com.google.gson.annotations.SerializedName

data class SigninRequest(

    @field:SerializedName("email")
    val email: String,

    @field:SerializedName("password")
    val password: String
)
