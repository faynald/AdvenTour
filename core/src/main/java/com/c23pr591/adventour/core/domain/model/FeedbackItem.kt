package com.c23pr591.adventour.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FeedbackItem(
    val id: Int,
    val createdAt: String? = null,
    val gunungId: Int? = null,
    val review: String? = null,
    val rating: Int? = null,
    val gunung: Gunung? = null,
    val userId: Int? = null,
    val user: User? = null,
    val updatedAt: String? = null
) : Parcelable
