package com.c23pr591.adventour.core.data.network.request

import com.google.gson.annotations.SerializedName

data class GiveRatingRequest(

    @field:SerializedName("gunungId")
    val gunungId: Int,

    @field:SerializedName("rating")
    val rating: Int,

    @field:SerializedName("review")
    val review: String
)
