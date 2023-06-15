package com.c23pr591.adventour.ui.main.setting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.c23pr591.adventour.core.data.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(private val repository: AppRepository) : ViewModel() {
    fun getUserData(token: String) = repository.getUserData(token).asLiveData()
    fun getToken() = repository.getTokem().asLiveData()
}