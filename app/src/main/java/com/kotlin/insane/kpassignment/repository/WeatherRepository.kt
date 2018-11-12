package com.kotlin.insane.kpassignment.repository

import com.kotlin.insane.kpassignment.api.RetrofitAdapter
import com.kotlin.insane.kpassignment.model.WeatherResponse
import com.kotlin.insane.kpassignment.util.appId
import com.kotlin.insane.kpassignment.util.cityId
import io.reactivex.Single

class WeatherRepository {
    fun getWeather(): Single<WeatherResponse> {
        return RetrofitAdapter.apiService.getWeather(cityId, appId)
    }
}