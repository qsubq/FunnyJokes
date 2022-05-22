package com.github.qsubq.funnyjockes.data.db.room.repository

import androidx.lifecycle.LiveData
import com.github.qsubq.funnyjockes.data.db.room.dao.JokeDao
import com.github.qsubq.funnyjockes.data.model.JokeModel
import javax.inject.Inject

class DataRealization @Inject constructor(private val jokeDao: JokeDao) : DataRepository {

    override val favouriteJokes: LiveData<List<JokeModel>>
        get() = jokeDao.getFavouriteJokes()

    override suspend fun insert(jokeModel: JokeModel) {
        jokeDao.insertFavourite(jokeModel)
    }

    override suspend fun delete(jokeModel: JokeModel) {
        jokeDao.deleteFavourite(jokeModel)
    }
}