package com.c23pr591.adventour.core.data.network.response

import com.google.gson.annotations.SerializedName

data class FeedbackResponse(

    @field:SerializedName("data")
    val data: List<FeedbackItemResponse?>? = null,

    @field:SerializedName("message")
    val message: String? = null
)

data class FeedbackItemResponse(

    @field:SerializedName("createdAt")
    val createdAt: String? = null,

    @field:SerializedName("gunungId")
    val gunungId: Int? = null,

    @field:SerializedName("review")
    val review: String? = null,

    @field:SerializedName("rating")
    val rating: Int? = null,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("userId")
    val userId: Int? = null,

    @field:SerializedName("user")
    val user: UserItemResponse? = null,

    @field:SerializedName("updatedAt")
    val updatedAt: String? = null
)

data class UserItemResponse(

    @field:SerializedName("nama")
    val nama: String? = null,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("domisili")
    val domisili: String? = null
)