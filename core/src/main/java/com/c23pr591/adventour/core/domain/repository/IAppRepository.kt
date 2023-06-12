package com.c23pr591.adventour.core.domain.repository

import com.c23pr591.adventour.core.data.Resource
import com.c23pr591.adventour.core.domain.model.Gunung
import kotlinx.coroutines.flow.Flow


interface IAppRepository {
    fun getGunungList(): Flow<Resource<List<Gunung>>>
}