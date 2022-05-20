package com.github.qsubq.funnyjockes.di

import com.github.qsubq.funnyjockes.data.network.retrofit.ServiceRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Singleton
    @Provides
    fun providesRepository(): ServiceRepository {
        return ServiceRepository()
    }

}