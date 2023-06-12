package com.c23pr591.adventour.core.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.c23pr591.adventour.core.data.local.entity.GunungEntity
import com.c23pr591.adventour.core.data.local.entity.GunungJawaBaratEntity
import com.c23pr591.adventour.core.data.local.entity.GunungJawaTengahEntity
import com.c23pr591.adventour.core.data.local.entity.GunungJawaTimurEntity

@Database(entities = [GunungEntity::class, GunungJawaBaratEntity::class, GunungJawaTengahEntity::class, GunungJawaTimurEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun dao(): AppDao

}