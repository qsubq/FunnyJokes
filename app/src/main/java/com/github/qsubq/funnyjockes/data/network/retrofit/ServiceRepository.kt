package com.github.qsubq.funnyjockes.data.network.retrofit

import com.github.qsubq.funnyjockes.data.model.JokeModel
import retrofit2.Response
import javax.inject.Inject


class ServiceRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getJoke(): Response<JokeModel> {
        return apiService.getJoke()
    }

}