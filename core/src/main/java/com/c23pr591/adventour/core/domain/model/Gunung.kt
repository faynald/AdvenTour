package com.c23pr591.adventour.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Gunung(
    val id: Int,
    val daerah: String,
    val nama: String,
    val ketinggian: Int,
    val lokasi: String,
    val trek: String,
    val jalur: String,
    val simaksi: Int,
    val level: Int,
    val createdAt: String,
    val updatedAt: String
) : Parcelable
