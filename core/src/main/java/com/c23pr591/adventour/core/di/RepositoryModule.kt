package com.c23pr591.adventour.core.di

import com.c23pr591.adventour.core.data.AppRepository
import com.c23pr591.adventour.core.domain.repository.IAppRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(repository: AppRepository): IAppRepository

}