package com.c23pr591.adventour.core.domain.model

import android.os.Parcelable

data class UserData(
    val id: Int? = null,
    val nama: String? = null,
    val jenisKelamin: String? = null,
    val umur: Int? = null,
    val domisili: String? = null,
    val pengalaman: Int? = null,
    val email: String? = null,
    val level: Int? = null
)
