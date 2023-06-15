package com.c23pr591.adventour.core.data

import com.c23pr591.adventour.core.data.local.LocalDataSource
import com.c23pr591.adventour.core.data.local.entity.UserLoginEntity
import com.c23pr591.adventour.core.data.network.ApiResponse
import com.c23pr591.adventour.core.data.network.NetworkDataSource
import com.c23pr591.adventour.core.data.network.request.SigninRequest
import com.c23pr591.adventour.core.data.network.request.SignupRequest
import com.c23pr591.adventour.core.data.network.response.FeedbackItemResponse
import com.c23pr591.adventour.core.data.network.response.GunungListResponse
import com.c23pr591.adventour.core.data.network.response.SignUpResponse
import com.c23pr591.adventour.core.data.network.response.SigninResponse
import com.c23pr591.adventour.core.domain.model.FeedbackItem
import com.c23pr591.adventour.core.domain.model.Gunung
import com.c23pr591.adventour.core.domain.repository.IAppRepository
import com.c23pr591.adventour.core.utils.FeedbackItemMapper
import com.c23pr591.adventour.core.utils.GunungJawaBaratMapper
import com.c23pr591.adventour.core.utils.GunungJawaTengahMapper
import com.c23pr591.adventour.core.utils.GunungJawaTimurMapper
import com.c23pr591.adventour.core.utils.GunungMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepository @Inject constructor(
    private val networkDataSource: NetworkDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IAppRepository{
    override fun getGunungList(): Flow<Resource<List<Gunung>>> =
        object : NetworkBoundResource<List<Gunung>, List<GunungListResponse>>() {
            override fun loadFromDB(): Flow<List<Gunung>> =
                localDataSource.getAllGunung().map {
                    GunungMapper.mapEntitiesToDomain(it)
                }

            override suspend fun createCall(): Flow<ApiResponse<List<GunungListResponse>>> =
                networkDataSource.getGunungList()

            override suspend fun saveCallResult(data: List<GunungListResponse>) {
                val gunungList = GunungMapper.mapResponsesToEntities(data)
                localDataSource.insertGunung(gunungList)
            }

            override fun shouldFetch(data: List<Gunung>?): Boolean {
                return data.isNullOrEmpty()
//                TODO("if phone has internet connection, fetch from API")
            }

        }.asFlow()

    override fun getGunungJawaBaratList(): Flow<Resource<List<Gunung>>> =
        object : NetworkBoundResource<List<Gunung>, List<GunungListResponse>>() {
            override fun loadFromDB(): Flow<List<Gunung>> =
                localDataSource.getAllGunungJawaBarat().map {
                    GunungJawaBaratMapper.mapEntitiesToDomain(it)
                }

            override suspend fun createCall(): Flow<ApiResponse<List<GunungListResponse>>> =
                networkDataSource.getGunungJawaBaratList()

            override suspend fun saveCallResult(data: List<GunungListResponse>) {
                val gunungList = GunungJawaBaratMapper.mapResponsesToEntities(data)
                localDataSource.insertGunungJawaBarat(gunungList)
            }

            override fun shouldFetch(data: List<Gunung>?): Boolean {
                return data.isNullOrEmpty()
//                TODO("if phone has internet connection, fetch from API")
            }

        }.asFlow()

    override fun getGunungJawaTengahList(): Flow<Resource<List<Gunung>>> =
        object : NetworkBoundResource<List<Gunung>, List<GunungListResponse>>() {
            override fun loadFromDB(): Flow<List<Gunung>> =
                localDataSource.getAllGunungJawaTengah().map {
                    GunungJawaTengahMapper.mapEntitiesToDomain(it)
                }

            override suspend fun createCall(): Flow<ApiResponse<List<GunungListResponse>>> =
                networkDataSource.getGunungJawaTengahList()

            override suspend fun saveCallResult(data: List<GunungListResponse>) {
                val gunungList = GunungJawaTengahMapper.mapResponsesToEntities(data)
                localDataSource.insertGunungJawaTengah(gunungList)
            }

            override fun shouldFetch(data: List<Gunung>?): Boolean {
                return data.isNullOrEmpty()
//                TODO("if phone has internet connection, fetch from API")
            }

        }.asFlow()

    override fun getGunungJawaTimurList(): Flow<Resource<List<Gunung>>> =
        object : NetworkBoundResource<List<Gunung>, List<GunungListResponse>>() {
            override fun loadFromDB(): Flow<List<Gunung>> =
                localDataSource.getAllGunungJawaTimur().map {
                    GunungJawaTimurMapper.mapEntitiesToDomain(it)
                }

            override suspend fun createCall(): Flow<ApiResponse<List<GunungListResponse>>> =
                networkDataSource.getGunungJawaTimurList()

            override suspend fun saveCallResult(data: List<GunungListResponse>) {
                val gunungList = GunungJawaTimurMapper.mapResponsesToEntities(data)
                localDataSource.insertGunungJawaTimur(gunungList)
            }

            override fun shouldFetch(data: List<Gunung>?): Boolean {
                return data.isNullOrEmpty()
//                TODO("if phone has internet connection, fetch from API")
            }

        }.asFlow()

    override fun getFeedbackById(gunungId: Int): Flow<Resource<List<FeedbackItem>>> =
        object : NetworkBoundResource<List<FeedbackItem>, List<FeedbackItemResponse?>?>() {
            override fun loadFromDB(): Flow<List<FeedbackItem>> =
                localDataSource.getFeedback(gunungId).map {
                    FeedbackItemMapper.mapEntitiesToDomain(it)
                }

            override suspend fun createCall(): Flow<ApiResponse<List<FeedbackItemResponse?>?>> =
                networkDataSource.getFeedbackById(gunungId)

            override suspend fun saveCallResult(data: List<FeedbackItemResponse?>?) {
                val feedbackList = FeedbackItemMapper.mapResponsesToEntities(data as List<FeedbackItemResponse>)
                localDataSource.insertFeedback(feedbackList)
            }


            override fun shouldFetch(data: List<FeedbackItem>?): Boolean {
                return data.isNullOrEmpty()
//                TODO("if phone has internet connection, fetch from API")
            }

        }.asFlow()

    override fun getAllFavorite(): Flow<List<Gunung>> =
        localDataSource.getAllFavorite().map {
            GunungMapper.mapEntitiesToDomain(it)
        }

    override fun setFavorite(gunungId: Int, newState: Boolean) {
        appExecutors.diskIO().execute { localDataSource.updateFavorite(gunungId, newState) }
    }

    fun signUpUser(user: SignupRequest, result: (response: SignUpResponse?) -> Unit) {
        networkDataSource.signUp(user) {
            result(it)
        }
    }

    fun signInUser(user: SigninRequest, result: (response: SigninResponse) -> Unit) {
        networkDataSource.signIn(user) {
            result(it)
        }
    }

    suspend fun saveUser(user: List<UserLoginEntity>) = localDataSource.insertUser(user)

    fun getTokem() =
        localDataSource.getToken()

}