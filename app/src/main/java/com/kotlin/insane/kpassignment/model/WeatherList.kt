package com.kotlin.insane.kpassignment.model

data class WeatherList(val dt: Int,
                       val main: MainDetail,
                       val weather: List<WeatherDetail>,
                       val dt_txt: String
)