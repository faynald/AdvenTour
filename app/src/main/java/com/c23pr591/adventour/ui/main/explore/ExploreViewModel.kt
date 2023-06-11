package com.c23pr591.adventour.ui.main.explore

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.c23pr591.adventour.core.data.AppRepository

class ExploreViewModel(private val repository: AppRepository) : ViewModel() {
    fun getAllGunung() = repository.getGunungList().asLiveData()
}