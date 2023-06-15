package com.c23pr591.adventour.ui.auth.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.c23pr591.adventour.core.data.AppRepository
import com.c23pr591.adventour.core.data.local.entity.UserLoginEntity
import com.c23pr591.adventour.core.data.network.request.SigninRequest
import com.c23pr591.adventour.core.data.network.response.SigninResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: AppRepository) : ViewModel() {
    fun signIn(user: SigninRequest, result: (response: SigninResponse?) -> Unit) = repository.signInUser(user) { it ->
        result(it)
        if (it.data != null) {
            it.data?.let { saveUser(it) }
        }
    }

    private fun saveUser(token: String) {
        viewModelScope.launch {
            repository.saveUser(
                listOf(
                    UserLoginEntity(
                        id = 1,
                        token = token
                    )
                )
            )
            Log.e("ViewModel SaveUser", "Success")
        }
    }
}