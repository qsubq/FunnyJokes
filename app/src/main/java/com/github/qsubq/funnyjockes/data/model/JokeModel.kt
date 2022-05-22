package com.github.qsubq.funnyjockes.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jokes_table")
data class JokeModel(

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo
    val joke: String = ""
)