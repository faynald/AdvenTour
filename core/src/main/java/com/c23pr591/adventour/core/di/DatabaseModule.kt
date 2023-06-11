package com.c23pr591.adventour.core.di

import android.content.Context
import androidx.room.Room
import com.c23pr591.adventour.core.data.local.room.AppDao
import com.c23pr591.adventour.core.data.local.room.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "adventour.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideTourismDao(database: AppDatabase): AppDao = database.dao()
}