package com.c23pr591.adventour.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.c23pr591.adventour.core.data.AppRepository
import com.c23pr591.adventour.core.data.local.entity.UserLoginEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val repository: AppRepository) : ViewModel() {
    fun getToken() = repository.getTokem().asLiveData()
    fun insertNullToken() {
        CoroutineScope(Dispatchers.IO).launch {
            repository.saveUser(
                listOf(
                    UserLoginEntity(1, "")
                )
            )
        }
    }
}