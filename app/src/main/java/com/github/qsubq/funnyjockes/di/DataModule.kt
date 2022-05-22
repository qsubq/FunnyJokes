package com.github.qsubq.funnyjockes.di

import android.content.Context
import androidx.room.Room
import com.github.qsubq.funnyjockes.data.db.room.JokesDataBase
import com.github.qsubq.funnyjockes.data.db.room.dao.JokeDao
import com.github.qsubq.funnyjockes.data.db.room.repository.DataRealization
import com.github.qsubq.funnyjockes.data.network.retrofit.ServiceRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Singleton
    @Provides
    fun providesServiceRepository(): ServiceRepository {
        return ServiceRepository()
    }

    @Singleton
    @Provides
    fun providesDataRepository(dao: JokeDao): DataRealization {
        return DataRealization(dao)
    }

    @Singleton
    @Provides
    fun provideJokeDao(jokesDataBase: JokesDataBase): JokeDao {
        return jokesDataBase.getDao()
    }

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext appContext: Context): JokesDataBase {
        return Room.databaseBuilder(
            appContext,
            JokesDataBase::class.java,
            "db"
        ).build()
    }
}