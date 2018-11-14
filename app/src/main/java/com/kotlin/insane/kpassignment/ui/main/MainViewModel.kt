package com.kotlin.insane.kpassignment.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kotlin.insane.kpassignment.model.WeatherList
import com.kotlin.insane.kpassignment.repository.WeatherRepository
import com.kotlin.insane.kpassignment.ui.DisposableViewModel
import com.kotlin.insane.kpassignment.ui.adapter.WeatherAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val repository: WeatherRepository): DisposableViewModel() {
    private val _itemObservable = MutableLiveData<WeatherList>()
    private lateinit var dataList: List<WeatherList>

    val itemObservable: LiveData<WeatherList> get() = _itemObservable

    val wetherListAdapter = WeatherAdapter()

    init {
        getWeather()
    }

    fun getWeather() {
        addDisposable(repository.getWeather()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result -> setWeatherAdapter(result.list) },
                { error -> Log.e("MainListViewModel", "ERROR: " + error.message) }
            )
        )
    }

    private fun setWeatherAdapter(weatherList: List<WeatherList>) {
        dataList = weatherList
        wetherListAdapter setItemClickMethod {
            this.onItemClick(it)
        }
        wetherListAdapter.updateWeatherList(weatherList)
    }

    fun onItemClick(position: Int) {
        _itemObservable.value = dataList[position]
    }
}