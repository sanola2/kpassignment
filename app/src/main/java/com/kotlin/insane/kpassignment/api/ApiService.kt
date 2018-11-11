package com.kotlin.insane.kpassignment.api

import com.kotlin.insane.kpassignment.model.WeatherResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/data/2.5/forecast")
    fun getWeather(@Query(value = "id", encoded = true) id: String,
                   @Query(value = "appid", encoded = true) appid: String): Single<WeatherResponse>
}