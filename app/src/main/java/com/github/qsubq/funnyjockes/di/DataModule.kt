package com.github.qsubq.funnyjockes.di

import com.github.qsubq.funnyjockes.data.db.room.dao.JokeDao
import com.github.qsubq.funnyjockes.data.db.room.repository.DataRealization
import com.github.qsubq.funnyjockes.data.network.NetworkManager
import com.github.qsubq.funnyjockes.data.network.retrofit.ApiService
import com.github.qsubq.funnyjockes.data.network.retrofit.ServiceRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class DataModule {

    @ViewModelScoped
    @Provides
    fun providesServiceRepository(apiService: ApiService): ServiceRepository {
        return ServiceRepository(apiService)
    }

    @ViewModelScoped
    @Provides
    fun providesDataRepository(dao: JokeDao): DataRealization {
        return DataRealization(dao)
    }

    @ViewModelScoped
    @Provides
    fun provideNetworkManager(): NetworkManager {
        return NetworkManager()
    }
}