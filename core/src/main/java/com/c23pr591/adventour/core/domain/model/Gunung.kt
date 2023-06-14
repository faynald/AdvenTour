package com.c23pr591.adventour.core.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import kotlinx.parcelize.Parcelize

@Parcelize
data class Gunung(
    val id: Int,
    val daerah: String?,
    val nama: String?,
    val ketinggian: Int?,
    val lokasi: String?,
    val trek: String?,
    val jalur: String?,
    val simaksi: Int?,
    val level: Int?,
    val rating: Double?,
    val imageUrl: String?,
    val createdAt: String?,
    val updatedAt: String?,
    val isFavorite: Boolean? = false
) : Parcelable
