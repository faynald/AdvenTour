package com.c23pr591.adventour.core.data.local

import com.c23pr591.adventour.core.data.local.entity.GunungEntity
import com.c23pr591.adventour.core.data.local.entity.GunungJawaBaratEntity
import com.c23pr591.adventour.core.data.local.entity.GunungJawaTengahEntity
import com.c23pr591.adventour.core.data.local.entity.GunungJawaTimurEntity
import com.c23pr591.adventour.core.data.local.room.AppDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val dao: AppDao) {
    fun getAllGunung(): Flow<List<GunungEntity>> = dao.getAllGunung()

    suspend fun insertGunung(gunung: List<GunungEntity>) = dao.insertGunung(gunung)

    fun getAllGunungJawaBarat(): Flow<List<GunungJawaBaratEntity>> = dao.getAllGunungJawaBarat()

    suspend fun insertGunungJawaBarat(gunung: List<GunungJawaBaratEntity>) = dao.insertGunungJawaBarat(gunung)

    fun getAllGunungJawaTengah(): Flow<List<GunungJawaTengahEntity>> = dao.getAllGunungJawaTengah()

    suspend fun insertGunungJawaTengah(gunung: List<GunungJawaTengahEntity>) = dao.insertGunungJawaTengah(gunung)

    fun getAllGunungJawaTimur(): Flow<List<GunungJawaTimurEntity>> = dao.getAllGunungJawaTimur()

    suspend fun insertGunungJawaTimur(gunung: List<GunungJawaTimurEntity>) = dao.insertGunungJawaTimur(gunung)
}