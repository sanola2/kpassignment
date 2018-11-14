package com.kotlin.insane.kpassignment.ui.main

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import com.kotlin.insane.kpassignment.model.WeatherList
import com.kotlin.insane.kpassignment.repository.WeatherRepository
import com.kotlin.insane.kpassignment.ui.DisposableViewModel
import com.kotlin.insane.kpassignment.ui.adapter.WeatherAdapter
import com.kotlin.insane.kpassignment.util.SingleLiveEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val repository: WeatherRepository): DisposableViewModel() {

    private val _itemObservable = SingleLiveEvent<WeatherList>()
    private val _progressBar = SingleLiveEvent<Int>()
    private lateinit var dataList: List<WeatherList>

    val itemObservable: LiveData<WeatherList> get() = _itemObservable
    val progressBar: LiveData<Int> get() = _progressBar

    val weatherListAdapter = WeatherAdapter()
    val refreshObserver = SingleLiveEvent<Int>()

    init {
        getWeather()
    }

    fun getWeather() {
        addDisposable(repository.getWeather()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onGetListState(View.VISIBLE) }
            .doAfterTerminate { onGetListState(View.INVISIBLE) }
            .subscribe(
                { result -> setWeatherAdapter(result.list) },
                { error -> Log.e("MainListViewModel", "ERROR: " + error.message) }
            )
        )
    }

    private fun setWeatherAdapter(weatherList: List<WeatherList>) {
        dataList = weatherList
        weatherListAdapter setItemClickMethod {
            this.onItemClick(it)
        }
        weatherListAdapter.updateWeatherList(weatherList)
        isFinishedGet()
    }

    fun onItemClick(position: Int) {
        _itemObservable.value = dataList[position]
    }

    private fun onGetListState(visibility: Int) {
        _progressBar.value = visibility
    }

    private fun isFinishedGet() {
        refreshObserver.call()
    }
}