package com.c23pr591.adventour.core.data.network

import android.util.Log
import com.c23pr591.adventour.core.data.network.response.GunungListResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkDataSource @Inject constructor(private val apiService: ApiService) {

    suspend fun getGunungList(): Flow<ApiResponse<List<GunungListResponse>>> {
        return flow {
            try {
                val response = apiService.getGunungList()
                val data = response.data
                if (data.isNotEmpty()) {
                    emit(ApiResponse.Success(response.data))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource getGunungList", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}