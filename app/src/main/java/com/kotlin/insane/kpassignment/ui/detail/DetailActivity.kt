package com.kotlin.insane.kpassignment.ui.detail

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.kotlin.insane.kpassignment.R
import com.kotlin.insane.kpassignment.databinding.ActivityDetailBinding
import com.kotlin.insane.kpassignment.ui.BaseActivity
import com.kotlin.insane.kpassignment.util.iconExt
import com.kotlin.insane.kpassignment.util.iconUrl
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity: BaseActivity<ActivityDetailBinding>() {

    override val layoutResourceId: Int = R.layout.activity_detail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val detailViewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        detailViewModel.initData(intent)
        drawImg()

        viewDataBinding.detailViewModel = detailViewModel
        viewDataBinding.setLifecycleOwner(this)
    }

    private fun drawImg() {
        Glide.with(this)
            .load(iconUrl + intent.getStringExtra("icon") + iconExt)
            .into(detail_img)
    }
}