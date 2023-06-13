package com.c23pr591.adventour.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class User(
    val id: Int,
    val nama: String? = null,
    val jenisKelamin: String? = null,
    val umur: Int? = null,
    val domisili: String? = null,
    val pengalaman: Int? = null,
    val email: String? = null,
    val updateAt: String? = null,
    val createdAt: String? = null
) : Parcelable
