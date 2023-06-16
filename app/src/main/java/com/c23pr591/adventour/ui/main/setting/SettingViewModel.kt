package com.c23pr591.adventour.ui.main.setting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.c23pr591.adventour.core.data.AppRepository
import com.c23pr591.adventour.core.data.local.entity.UserLoginEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(private val repository: AppRepository) : ViewModel() {
    fun getUserData(token: String) = repository.getUserData(token).asLiveData()
    fun getToken() = repository.getTokem().asLiveData()
    fun deleteToken(user: UserLoginEntity) {
        viewModelScope.launch {
            repository.deleteToken(user)
        }
    }
}