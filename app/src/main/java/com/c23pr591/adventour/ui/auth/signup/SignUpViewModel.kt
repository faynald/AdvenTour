package com.c23pr591.adventour.ui.auth.signup

import androidx.lifecycle.ViewModel
import com.c23pr591.adventour.core.data.AppRepository
import com.c23pr591.adventour.core.data.network.request.SignupRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val repository: AppRepository) : ViewModel() {
    fun signUp(user: SignupRequest) = repository.signUpUser(user)
}