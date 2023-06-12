package com.c23pr591.adventour.core.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.c23pr591.adventour.core.data.local.entity.GunungEntity
import com.c23pr591.adventour.core.data.local.entity.GunungJawaBaratEntity
import com.c23pr591.adventour.core.data.local.entity.GunungJawaTengahEntity
import com.c23pr591.adventour.core.data.local.entity.GunungJawaTimurEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDao {
    @Query("SELECT * FROM gunung_entity")
    fun getAllGunung(): Flow<List<GunungEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGunung(gunungList: List<GunungEntity>)

    @Query("SELECT * FROM gunung_jawa_barat_entity")
    fun getAllGunungJawaBarat(): Flow<List<GunungJawaBaratEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGunungJawaBarat(gunungList: List<GunungJawaBaratEntity>)

    @Query("SELECT * FROM gunung_jawa_tengah_entity")
    fun getAllGunungJawaTengah(): Flow<List<GunungJawaTengahEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGunungJawaTengah(gunungList: List<GunungJawaTengahEntity>)

    @Query("SELECT * FROM gunung_jawa_timur_entity")
    fun getAllGunungJawaTimur(): Flow<List<GunungJawaTimurEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGunungJawaTimur(gunungList: List<GunungJawaTimurEntity>)


}