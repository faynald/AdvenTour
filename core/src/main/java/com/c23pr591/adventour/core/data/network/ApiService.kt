package com.c23pr591.adventour.core.data.network

import com.c23pr591.adventour.core.data.network.response.GunungResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/")
    suspend fun getGunungList(): GunungResponse

    @GET("{id}")
    suspend fun getGunungById(@Path("id") id: Int): GunungResponse
}