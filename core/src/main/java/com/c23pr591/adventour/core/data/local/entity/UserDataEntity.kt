package com.c23pr591.adventour.core.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_data_entity")
data class UserDataEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int? = null,
    val umur: Int? = null,
    val nama: String? = null,
    val level: Int? = null,
    val pengalaman: Int? = null,
    @ColumnInfo(name = "jenis_kelamin")
    val jenisKelamin: String? = null,
    val domisili: String? = null,
    val email: String? = null
)
