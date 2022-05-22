package com.github.qsubq.funnyjockes.screen.favourite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.github.qsubq.funnyjockes.data.db.room.repository.DataRealization
import com.github.qsubq.funnyjockes.data.model.JokeModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavouriteViewModel @Inject constructor(private val dataRealization: DataRealization) :
    ViewModel() {

    fun getFavouriteJokes(): LiveData<List<JokeModel>> {
        return dataRealization.favouriteJokes
    }
}