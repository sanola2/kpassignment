package com.kotlin.insane.kpassignment.ui.detail

import android.content.Intent
import androidx.lifecycle.LiveData
import com.kotlin.insane.kpassignment.ui.DisposableViewModel
import com.kotlin.insane.kpassignment.util.SingleLiveEvent

class DetailViewModel: DisposableViewModel() {

    private val _detailDate = SingleLiveEvent<String>()
    private val _detailDescription = SingleLiveEvent<String>()
    private val _detailTemp = SingleLiveEvent<String>()
    private val _detailHumidity = SingleLiveEvent<String>()
    private val _detailPressure = SingleLiveEvent<String>()

    val detailDate: LiveData<String> get() = _detailDate
    val detailDescription: LiveData<String> get() = _detailDescription
    val detailTemp: LiveData<String> get() = _detailTemp
    val detailHumidity: LiveData<String> get() = _detailHumidity
    val detailPressure: LiveData<String> get() = _detailPressure

    fun initData(intent: Intent) {
        _detailDate.value = intent.getStringExtra("date")
        _detailDescription.value = intent.getStringExtra("description")
        _detailTemp.value = "온도   " + intent.getStringExtra("temp")
        _detailHumidity.value = "습도   " + intent.getStringExtra("humidity") + " %"
        _detailPressure.value = "기압   " + intent.getStringExtra("pressure") + " hPa"
    }

}