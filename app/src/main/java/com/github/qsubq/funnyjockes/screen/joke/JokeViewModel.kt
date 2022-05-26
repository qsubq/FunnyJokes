package com.github.qsubq.funnyjockes.screen.joke

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.github.qsubq.funnyjockes.data.db.room.repository.DataRealization
import com.github.qsubq.funnyjockes.data.model.JokeModel
import com.github.qsubq.funnyjockes.data.network.NetworkManager
import com.github.qsubq.funnyjockes.data.network.retrofit.ServiceRepository
import com.github.qsubq.funnyjockes.di.IoDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class JokeViewModel @Inject constructor(
    private val context: Application,
    private val serviceRepository: ServiceRepository,
    private val dataRealization: DataRealization,
    private val networkManager: NetworkManager,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : AndroidViewModel(context) {

    val jokeLiveData: MutableLiveData<Response<JokeModel>> = MutableLiveData()


    fun getJoke() {
        viewModelScope.launch {
            jokeLiveData.value = serviceRepository.getJoke()
        }
    }

    fun insertJoke(jokeModel: JokeModel) =
        viewModelScope.launch(ioDispatcher) {
            dataRealization.insert(jokeModel)

        }

    fun isOnline(): Boolean {
        return networkManager.isOnline(context)
    }
}
