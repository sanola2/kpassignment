package com.kotlin.insane.kpassignment.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.insane.kpassignment.R
import com.kotlin.insane.kpassignment.databinding.ActivityMainBinding
import com.kotlin.insane.kpassignment.model.WeatherList
import com.kotlin.insane.kpassignment.repository.WeatherRepository
import com.kotlin.insane.kpassignment.ui.BaseActivity
import com.kotlin.insane.kpassignment.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val layoutResourceId: Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        weather_rv.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val mainViewModelFactory = MainViewModelFactory(WeatherRepository())
        val mainViewModel = ViewModelProviders.of(this, mainViewModelFactory).get(MainViewModel::class.java)

        mainViewModel.itemObservable.observe(this, Observer { goToDetailActivity(it!!) })
        swipe_container.setOnRefreshListener { mainViewModel.getWeather() }
        mainViewModel.refreshObserver.observe(this, Observer { swipe_container.isRefreshing = false })
        
        viewDataBinding.mainViewModel = mainViewModel
        viewDataBinding.setLifecycleOwner(this)
    }

    fun goToDetailActivity(item: WeatherList) {
        Intent(this, DetailActivity::class.java).apply {
            putExtra("icon", item.weather[0].icon)
            putExtra("description", item.weather[0].description)
            putExtra("date", item.dt_txt)
            putExtra("temp", item.main.temp.toString())
            putExtra("pressure", item.main.pressure.toString())
            putExtra("humidity", item.main.humidity.toString())
        }.also { startActivity(it) }
    }
}
