package com.c23pr591.adventour.core.data.local

import androidx.room.TypeConverter
import com.c23pr591.adventour.core.domain.model.User
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class Converters {
    @TypeConverter
    fun fromUser(value: User) =
        Json.encodeToString(value)

    @TypeConverter
    fun toUser(value: String) =
        Json.decodeFromString<User>(value)
}