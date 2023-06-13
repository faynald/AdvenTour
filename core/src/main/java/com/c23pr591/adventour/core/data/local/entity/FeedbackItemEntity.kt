package com.c23pr591.adventour.core.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.c23pr591.adventour.core.domain.model.Gunung
import com.c23pr591.adventour.core.domain.model.User

@Entity(tableName = "feedback_entity")
data class FeedbackItemEntity(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "created_at")
    val createdAt: String? = null,
    @ColumnInfo(name = "gunung_id")
    val gunungId: Int? = null,
    val review: String? = null,
    val rating: Int? = null,
    @ColumnInfo(name = "user_id")
    val userId: Int? = null,
    val user: User? = null,
    @ColumnInfo(name = "updated_at")
    val updatedAt: String? = null
)
