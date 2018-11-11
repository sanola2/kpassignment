package com.kotlin.insane.kpassignment.model

data class WeatherResponse(val cod: String,
                           val message: Double,
                           val cnt: Int,
                           val list: List<WeatherList>,
                           val city: CityInfo
)