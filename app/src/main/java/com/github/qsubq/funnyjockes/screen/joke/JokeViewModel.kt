package com.github.qsubq.funnyjockes.screen.joke

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.qsubq.funnyjockes.data.model.JokeModel
import com.github.qsubq.funnyjockes.data.network.retrofit.ServiceRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class JokeViewModel : ViewModel() {
    val jokeLiveData: MutableLiveData<Response<JokeModel>> = MutableLiveData()
    val repo = ServiceRepository()

    fun getJoke() {
        viewModelScope.launch {
            jokeLiveData.value = repo.getJoke()
        }
    }
}