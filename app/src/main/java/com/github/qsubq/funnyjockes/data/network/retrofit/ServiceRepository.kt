package com.github.qsubq.funnyjockes.data.network.retrofit

import com.github.qsubq.funnyjockes.data.model.JokeModel
import io.reactivex.Single
import retrofit2.Response

class ServiceRepository {
    suspend fun getJoke() : Response<JokeModel>{
        return RetrofitInstance.api.getJoke()
    }

}