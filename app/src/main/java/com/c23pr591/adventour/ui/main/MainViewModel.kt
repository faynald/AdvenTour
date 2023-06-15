package com.c23pr591.adventour.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.c23pr591.adventour.core.data.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: AppRepository) : ViewModel() {
    fun getToken() = repository.getTokem().asLiveData()
}