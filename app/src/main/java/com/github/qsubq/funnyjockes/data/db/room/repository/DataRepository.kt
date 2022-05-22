package com.github.qsubq.funnyjockes.data.db.room.repository

import androidx.lifecycle.LiveData
import com.github.qsubq.funnyjockes.data.model.JokeModel

interface DataRepository {
    val favouriteJokes: LiveData<List<JokeModel>>
    suspend fun insert(jokeModel: JokeModel)
    suspend fun delete(jokeModel: JokeModel)
}