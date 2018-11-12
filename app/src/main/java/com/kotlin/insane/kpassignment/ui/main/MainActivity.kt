package com.kotlin.insane.kpassignment.ui.main

import android.os.Bundle
import com.kotlin.insane.kpassignment.R
import com.kotlin.insane.kpassignment.databinding.ActivityMainBinding
import com.kotlin.insane.kpassignment.ui.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val layoutResourceId: Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}
