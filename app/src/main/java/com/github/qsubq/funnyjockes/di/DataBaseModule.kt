package com.github.qsubq.funnyjockes.di

import android.content.Context
import androidx.room.Room
import com.github.qsubq.funnyjockes.data.db.room.JokesDataBase
import com.github.qsubq.funnyjockes.data.db.room.dao.JokeDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

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