package com.kotlin.insane.kpassignment.ui.main

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.kotlin.insane.kpassignment.R
import com.kotlin.insane.kpassignment.databinding.ActivityMainBinding
import com.kotlin.insane.kpassignment.repository.WeatherRepository
import com.kotlin.insane.kpassignment.ui.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val layoutResourceId: Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainViewModelFactory = MainViewModelFactory(WeatherRepository())
        val mainViewModel = ViewModelProviders.of(this, mainViewModelFactory).get(MainViewModel::class.java)

        viewDataBinding.mainViewModel = mainViewModel
        viewDataBinding.setLifecycleOwner(this)
    }
}
