package com.c23pr591.adventour.core.data.network

import com.c23pr591.adventour.core.data.network.response.FeedbackResponse
import com.c23pr591.adventour.core.data.network.response.GunungResponse
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @GET("gunung")
    suspend fun getGunungList(): GunungResponse

    @GET("gunung/jawa-barat")
    suspend fun getGunungJawaBaratList(): GunungResponse

    @GET("gunung/jawa-tengah")
    suspend fun getGunungJawaTengahList(): GunungResponse

    @GET("gunung/jawa-timur")
    suspend fun getGunungJawaTimurList(): GunungResponse

    @GET("feedback/{id}")
    suspend fun getFeedbackById(@Path("id") gunungId: Int): FeedbackResponse

    @GET("{id}")
    suspend fun getGunungById(@Path("id") id: Int): GunungResponse

}