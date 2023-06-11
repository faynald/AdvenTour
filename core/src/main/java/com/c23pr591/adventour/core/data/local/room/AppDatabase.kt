package com.c23pr591.adventour.core.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.c23pr591.adventour.core.data.local.entity.GunungEntity

@Database(entities = [GunungEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun dao(): AppDao

}