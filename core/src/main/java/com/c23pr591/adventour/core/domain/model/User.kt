package com.c23pr591.adventour.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val id: Int,
    val nama: String,
    val jenisKelamin: String,
    val umur: Int,
    val domisili: String,
    val pengalaman: Int,
    val email: String,
    val updateAt: String,
    val createdAt: String
) : Parcelable
