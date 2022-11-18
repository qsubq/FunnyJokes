package com.github.qsubq.funnyjockes.data.db.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.github.qsubq.funnyjockes.data.db.room.dao.JokeDao
import com.github.qsubq.funnyjockes.data.model.JokeModel

@Database(entities = [JokeModel::class], version = 1)
abstract class JokesDataBase : RoomDatabase() {
    abstract fun getDao(): JokeDao
}