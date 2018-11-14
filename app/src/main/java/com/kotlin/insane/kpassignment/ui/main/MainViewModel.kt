package com.kotlin.insane.kpassignment.ui.main

import android.util.Log
import com.kotlin.insane.kpassignment.model.WeatherList
import com.kotlin.insane.kpassignment.repository.WeatherRepository
import com.kotlin.insane.kpassignment.ui.DisposableViewModel
import com.kotlin.insane.kpassignment.ui.adapter.WeatherAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val repository: WeatherRepository): DisposableViewModel() {
    val wetherListAdapter = WeatherAdapter()

    init {
        getWeather()
    }

    fun getWeather() {
        addDisposable(repository.getWeather()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result -> setWeatherListDatas(result.list) },
                { error -> Log.e("MainListViewModel", "ERROR: " + error.message) }
            )
        )
    }

    private fun setWeatherListDatas(weatherList: List<WeatherList>) {
        wetherListAdapter.updateWeatherList(weatherList)
    }
}