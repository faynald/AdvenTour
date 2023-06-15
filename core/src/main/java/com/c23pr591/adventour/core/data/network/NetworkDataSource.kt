package com.c23pr591.adventour.core.data.network

import android.util.Log
import com.c23pr591.adventour.core.data.network.request.SigninRequest
import com.c23pr591.adventour.core.data.network.request.SignupRequest
import com.c23pr591.adventour.core.data.network.response.FeedbackItemResponse
import com.c23pr591.adventour.core.data.network.response.GunungListResponse
import com.c23pr591.adventour.core.data.network.response.SignUpResponse
import com.c23pr591.adventour.core.data.network.response.SigninResponse
import com.c23pr591.adventour.core.data.network.response.UserDataResponseItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkDataSource @Inject constructor(private val apiService: ApiService) {

    suspend fun getGunungList(): Flow<ApiResponse<List<GunungListResponse>>> {
        return flow {
            try {
                val response = apiService.getGunungList()
                val data = response.data
                if (data.isNotEmpty()) {
                    emit(ApiResponse.Success(response.data))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource getGunungList", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getGunungJawaBaratList(): Flow<ApiResponse<List<GunungListResponse>>> {
        return flow {
            try {
                val response = apiService.getGunungJawaBaratList()
                val data = response.data
                if (data.isNotEmpty()) {
                    emit(ApiResponse.Success(response.data))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource getGunungJawaBaratList", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getGunungJawaTengahList(): Flow<ApiResponse<List<GunungListResponse>>> {
        return flow {
            try {
                val response = apiService.getGunungJawaTengahList()
                val data = response.data
                if (data.isNotEmpty()) {
                    emit(ApiResponse.Success(response.data))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource getGunungJawaTengahList", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getGunungJawaTimurList(): Flow<ApiResponse<List<GunungListResponse>>> {
        return flow {
            try {
                val response = apiService.getGunungJawaTimurList()
                val data = response.data
                if (data.isNotEmpty()) {
                    emit(ApiResponse.Success(response.data))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource getGunungJawaTimurList", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getFeedbackById(gunungId: Int): Flow<ApiResponse<List<FeedbackItemResponse?>?>> {
        return flow {
            try {
                val response = apiService.getFeedbackById(gunungId)
                val data = response.data
                if (data != null) {
                    if (data.isNotEmpty()) {
                        emit(ApiResponse.Success(response.data))
                    } else {
                        emit(ApiResponse.Empty)
                    }
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource getGunungJawaTimurList", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    fun signUp(user: SignupRequest, result: (response: SignUpResponse?) -> Unit) {
        val call: Call<SignUpResponse> = apiService.signUp(user)
        call.enqueue(object : Callback<SignUpResponse> {
            override fun onResponse(
                call: Call<SignUpResponse>,
                response: Response<SignUpResponse>
            ) {
                Log.e("RemoteDataSource signUp Success", response.code().toString())
                result(response.body())
            }

            override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                Log.e("RemoteDataSource signUp", "Error$t")
            }
        })
        apiService.signUp(user)
    }

    fun signIn(user: SigninRequest, result: (response: SigninResponse) -> Unit) {
        val call: Call<SigninResponse> = apiService.signIn(user)
        call.enqueue(object : Callback<SigninResponse> {
            override fun onResponse(
                call: Call<SigninResponse>,
                response: Response<SigninResponse>
            ) {
                Log.e("RemoteDataSource signUp Success", response.code().toString())
                response.body()?.let { result(it) }
            }

            override fun onFailure(call: Call<SigninResponse>, t: Throwable) {
                Log.e("RemoteDataSource signUp", "Error$t")
            }
        })
        apiService.signIn(user)
    }

    suspend fun getRecommendation(token: String): Flow<ApiResponse<List<GunungListResponse>>> {
        return flow {
            try {
                val response = apiService.getRecommendation(token)
                val data = response.data
                if (data.isNotEmpty()) {
                    emit(ApiResponse.Success(response.data))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource gerRecommendation", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getUserData(token: String): Flow<ApiResponse<List<UserDataResponseItem>>> {
        return flow {
            try {
                val response = apiService.getUserData(token)
                val data = response.data
                if (data != null) {
                    emit(ApiResponse.Success(listOf(response.data)))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource gerRecommendation", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

}