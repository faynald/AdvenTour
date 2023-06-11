package com.c23pr591.adventour.core.data.network.request

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class SigninRequest(

    @field:SerializedName("email")
    val email: String,

    @field:SerializedName("password")
    val password: String
) : Parcelable
