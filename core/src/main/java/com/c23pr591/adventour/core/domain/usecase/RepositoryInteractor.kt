package com.c23pr591.adventour.core.domain.usecase

import com.c23pr591.adventour.core.data.Resource
import com.c23pr591.adventour.core.domain.model.Gunung
import com.c23pr591.adventour.core.domain.repository.IAppRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryInteractor @Inject constructor(private val repository: IAppRepository): RepositoryUseCase {
    override fun getGunungList() = repository.getGunungList()

}