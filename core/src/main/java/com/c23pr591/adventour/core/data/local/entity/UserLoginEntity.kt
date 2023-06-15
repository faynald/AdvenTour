package com.c23pr591.adventour.core.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_login")
data class UserLoginEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "token")
    val token: String,
//    val nama: String? = null,
//    val jenisKelamin: String? = null,
//    val umur: Int? = null,
//    val domisili: String? = null,
//    val pengalaman: Int? = null,
//    val email: String? = null,
//    val updateAt: String? = null,
//    val createdAt: String? = null
)
