package com.github.qsubq.funnyjockes.data.network.retrofit

import com.github.qsubq.funnyjockes.data.model.JokeModel
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("api?format=json")
    suspend fun getJoke() : Response<JokeModel>
}