package com.c23pr591.adventour.core.data.local

import com.c23pr591.adventour.core.data.local.entity.GunungEntity
import com.c23pr591.adventour.core.data.local.room.AppDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val dao: AppDao) {
    fun getAllGunung(): Flow<List<GunungEntity>> = dao.getAllGunung()

    suspend fun insertGunung(gunung: List<GunungEntity>) = dao.insertGunung(gunung)
}