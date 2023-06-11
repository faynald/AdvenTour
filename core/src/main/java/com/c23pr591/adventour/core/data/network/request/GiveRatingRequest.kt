package com.c23pr591.adventour.core.data.network.request

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class GiveRatingRequest(

    @field:SerializedName("gunungId")
    val gunungId: Int,

    @field:SerializedName("rating")
    val rating: Int,

    @field:SerializedName("review")
    val review: String
) : Parcelable
