package com.c23pr591.adventour.core.data.network.response

import com.google.gson.annotations.SerializedName

data class GunungResponse(
    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("data")
    val data: List<GunungListResponse>
)

data class GunungListResponse(
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("daerah")
    val daerah: String?,

    @field:SerializedName("nama")
    val nama: String?,

    @field:SerializedName("ketinggian")
    val ketinggian: Int?,

    @field:SerializedName("lokasi")
    val lokasi: String?,

    @field:SerializedName("trek")
    val trek: String?,

    @field:SerializedName("jalur")
    val jalur: String?,

    @field:SerializedName("simaksi")
    val simaksi: Int?,

    @field:SerializedName("level")
    val level: Int?,

    @field:SerializedName("rating")
    val rating: Double?,

    @field:SerializedName("imageUrl")
    val imageUrl: String?,

    @field:SerializedName("createdAt")
    val createdAt: String?,

    @field:SerializedName("updateAt")
    val updatedAt: String?
)
