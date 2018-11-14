package com.kotlin.insane.kpassignment.ui.main

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.insane.kpassignment.R
import com.kotlin.insane.kpassignment.databinding.ActivityMainBinding
import com.kotlin.insane.kpassignment.repository.WeatherRepository
import com.kotlin.insane.kpassignment.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val layoutResourceId: Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        weather_rv.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val mainViewModelFactory = MainViewModelFactory(WeatherRepository())
        val mainViewModel = ViewModelProviders.of(this, mainViewModelFactory).get(MainViewModel::class.java)

        viewDataBinding.mainViewModel = mainViewModel
        viewDataBinding.setLifecycleOwner(this)
    }
}
