package com.c23pr591.adventour.core.domain.usecase

import com.c23pr591.adventour.core.data.Resource
import com.c23pr591.adventour.core.domain.model.FeedbackItem
import com.c23pr591.adventour.core.domain.model.Gunung
import kotlinx.coroutines.flow.Flow

interface RepositoryUseCase {
    fun getGunungList(): Flow<Resource<List<Gunung>>>
    fun getGunungJawaBaratList(): Flow<Resource<List<Gunung>>>
    fun getGunungJawaTengahList(): Flow<Resource<List<Gunung>>>
    fun getGunungTimurList(): Flow<Resource<List<Gunung>>>
    fun getFeedbackById(gunungId: Int): Flow<Resource<List<FeedbackItem>>>
}