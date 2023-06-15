package com.c23pr591.adventour.core.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gunung_recommendation_entity")
data class GunungRecommendationEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id: Int,
    val daerah: String?,
    val nama: String?,
    val ketinggian: Int?,
    val lokasi: String?,
    val trek: String?,
    val jalur: String?,
    val simaksi: Int?,
    val level: Int?,
    val rating: Double?,
    @ColumnInfo(name = "image_url")
    val imageUrl: String?,
    @ColumnInfo(name = "created_at")
    val createdAt: String?,
    @ColumnInfo(name = "updated_at")
    val updatedAt: String?,
)
