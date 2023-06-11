package com.c23pr591.adventour.core.data

import com.c23pr591.adventour.core.data.local.LocalDataSource
import com.c23pr591.adventour.core.data.network.ApiResponse
import com.c23pr591.adventour.core.data.network.NetworkDataSource
import com.c23pr591.adventour.core.data.network.response.GunungListResponse
import com.c23pr591.adventour.core.domain.model.Gunung
import com.c23pr591.adventour.core.utils.GunungMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AppRepository(
    private val networkDataSource: NetworkDataSource,
    private val localDataSource: LocalDataSource,
//    private val appExecutors: AppExecutors
) {
    fun getGunungList(): Flow<Resource<List<Gunung>>> =
        object : NetworkBoundResource<List<Gunung>, List<GunungListResponse>>() {
            override fun loadFromDB(): Flow<List<Gunung>> =
                localDataSource.getAllGunung().map {
                    GunungMapper.mapEntitiesToDomain(it)
                }

            override suspend fun createCall(): Flow<ApiResponse<List<GunungListResponse>>> =
                networkDataSource.getGunungList()

            override suspend fun saveCallResult(data: List<GunungListResponse>) {
                val gunungList = GunungMapper.mapResponsesToEntities(data)
                localDataSource.insertGunung(gunungList)
            }

            override fun shouldFetch(data: List<Gunung>?): Boolean {
                return data.isNullOrEmpty()
//                TODO("if phone has internet connection, fetch from API")
            }

        }.asFlow()
}