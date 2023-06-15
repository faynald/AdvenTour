package com.c23pr591.adventour.core.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.c23pr591.adventour.core.data.local.entity.FeedbackItemEntity
import com.c23pr591.adventour.core.data.local.entity.GunungEntity
import com.c23pr591.adventour.core.data.local.entity.GunungJawaBaratEntity
import com.c23pr591.adventour.core.data.local.entity.GunungJawaTengahEntity
import com.c23pr591.adventour.core.data.local.entity.GunungJawaTimurEntity
import com.c23pr591.adventour.core.data.local.entity.UserLoginEntity
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

    @Query("SELECT * FROM feedback_entity WHERE gunung_id = :gunungId")
    fun getFeedbackByGunung(gunungId: Int): Flow<List<FeedbackItemEntity>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFeedback(feedback: List<FeedbackItemEntity>)

    // set favorite
    @Query("SELECT * FROM gunung_entity WHERE is_favorite = 1")
    fun getAllFavorite(): Flow<List<GunungEntity>>

    @Query("UPDATE gunung_entity SET is_favorite = :newState WHERE id = :gunungId")
    fun updateFavorite(gunungId: Int, newState: Boolean)

    // Authentication
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(data: List<UserLoginEntity>)

    @Query("SELECT * FROM user_login WHERE id = 1")
    fun getToken(): Flow<List<UserLoginEntity>>


}