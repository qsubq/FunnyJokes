package com.github.qsubq.funnyjockes.data.db.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.github.qsubq.funnyjockes.data.model.JokeModel

@Dao
interface JokeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFavourite(jokeModel: JokeModel)

    @Delete
    suspend fun deleteFavourite(jokeModel: JokeModel)

    @Query("SELECT * from jokes_table")
    fun getFavouriteJokes() : LiveData<List<JokeModel>>
}