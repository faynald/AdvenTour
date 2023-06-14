package com.c23pr591.adventour.core.domain.usecase

import com.c23pr591.adventour.core.data.Resource
import com.c23pr591.adventour.core.domain.model.FeedbackItem
import com.c23pr591.adventour.core.domain.model.Gunung
import com.c23pr591.adventour.core.domain.repository.IAppRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryInteractor @Inject constructor(private val repository: IAppRepository): RepositoryUseCase {
    override fun getGunungList() = repository.getGunungList()
    override fun getGunungJawaBaratList() = repository.getGunungJawaBaratList()

    override fun getGunungJawaTengahList() = repository.getGunungJawaTengahList()

    override fun getGunungTimurList() = repository.getGunungJawaTimurList()

    override fun getFeedbackById(gunungId: Int) = repository.getFeedbackById(gunungId)
    override fun getAllFavorite() = repository.getAllFavorite()

    override fun setFavorite(gunungId: Int, newState: Boolean) = repository.setFavorite(gunungId, newState)

}