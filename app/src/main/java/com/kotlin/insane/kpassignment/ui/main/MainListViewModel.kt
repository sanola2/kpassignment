package com.kotlin.insane.kpassignment.ui.main

import androidx.lifecycle.LiveData
import com.kotlin.insane.kpassignment.model.WeatherList
import com.kotlin.insane.kpassignment.ui.DisposableViewModel
import com.kotlin.insane.kpassignment.util.SingleLiveEvent

class MainListViewModel: DisposableViewModel() {

    private val _listIcon = SingleLiveEvent<String>()
    private val _listDate = SingleLiveEvent<String>()
    private val _listDescription = SingleLiveEvent<String>()

    val listIcon: LiveData<String> get() = _listIcon
    val listDate: LiveData<String> get() = _listDate
    val listDescription: LiveData<String> get() = _listDescription

    fun bind(weatherList: WeatherList) {
        _listIcon.value = weatherList.weather.get(0).icon
        _listDate.value = weatherList.dt_txt
        _listDescription.value = weatherList.weather.get(0).description
    }
}