package com.c23pr591.adventour.core.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.c23pr591.adventour.core.data.local.Converters
import com.c23pr591.adventour.core.data.local.entity.FeedbackItemEntity
import com.c23pr591.adventour.core.data.local.entity.GunungEntity
import com.c23pr591.adventour.core.data.local.entity.GunungJawaBaratEntity
import com.c23pr591.adventour.core.data.local.entity.GunungJawaTengahEntity
import com.c23pr591.adventour.core.data.local.entity.GunungJawaTimurEntity
import com.c23pr591.adventour.core.data.local.entity.GunungRecommendationEntity
import com.c23pr591.adventour.core.data.local.entity.UserDataEntity
import com.c23pr591.adventour.core.data.local.entity.UserLoginEntity

@Database(entities = [GunungEntity::class, GunungJawaBaratEntity::class, GunungJawaTengahEntity::class, GunungJawaTimurEntity::class, FeedbackItemEntity::class, UserLoginEntity::class, GunungRecommendationEntity::class, UserDataEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun dao(): AppDao

}