package com.c23pr591.adventour.core.domain.repository

import com.c23pr591.adventour.core.data.Resource
import com.c23pr591.adventour.core.data.network.response.FeedbackItemResponse
import com.c23pr591.adventour.core.domain.model.FeedbackItem
import com.c23pr591.adventour.core.domain.model.Gunung
import kotlinx.coroutines.flow.Flow


interface IAppRepository {
    fun getGunungList(): Flow<Resource<List<Gunung>>>
    fun getGunungJawaBaratList(): Flow<Resource<List<Gunung>>>
    fun getGunungJawaTengahList(): Flow<Resource<List<Gunung>>>
    fun getGunungJawaTimurList(): Flow<Resource<List<Gunung>>>

    fun getFeedbackById(gunungId: Int): Flow<Resource<List<FeedbackItem>>>

    fun getAllFavorite(): Flow<List<Gunung>>

    fun setFavorite(gunungId: Int, state: Boolean)
}