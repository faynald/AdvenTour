package com.c23pr591.adventour.core.domain.usecase

import com.c23pr591.adventour.core.data.Resource
import com.c23pr591.adventour.core.domain.model.Gunung
import kotlinx.coroutines.flow.Flow

interface RepositoryUseCase {
    fun getGunungList(): Flow<Resource<List<Gunung>>>
}