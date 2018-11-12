package com.kotlin.insane.kpassignment.ui

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<T: ViewDataBinding>: AppCompatActivity() {

    lateinit var viewDataBinding: T
    abstract val layoutResourceId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewDataBinding = DataBindingUtil.setContentView(this, layoutResourceId)
    }
}