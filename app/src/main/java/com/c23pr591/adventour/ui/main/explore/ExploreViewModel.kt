package com.c23pr591.adventour.ui.main.explore

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.c23pr591.adventour.core.data.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ExploreViewModel @Inject constructor(private val repository: AppRepository) : ViewModel() {

    fun getAllGunung() = repository.getGunungList().asLiveData()

    fun getAllGunungJawaBarat() = repository.getGunungJawaBaratList().asLiveData()

    fun getAllGunungJawaTengah() = repository.getGunungJawaTengahList().asLiveData()

    fun getAllGunungJawaTimur() = repository.getGunungJawaTimurList().asLiveData()
}