package com.kotlin.insane.kpassignment.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.insane.kpassignment.R
import com.kotlin.insane.kpassignment.databinding.ItemWeatherBinding
import com.kotlin.insane.kpassignment.model.WeatherList
import com.kotlin.insane.kpassignment.ui.main.MainListViewModel

class WeatherAdapter: RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {
    private lateinit var weatherList: List<WeatherList>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherAdapter.ViewHolder {
        val binding: ItemWeatherBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_weather, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(weatherList[position])
    }

    override fun getItemCount(): Int {
        return if(::weatherList.isInitialized) weatherList.size else 0
    }

    class ViewHolder(private val binding: ItemWeatherBinding): RecyclerView.ViewHolder(binding.root) {
        private val viewModel = MainListViewModel()

        fun bind(weatherList: WeatherList) {
            viewModel.bind(weatherList)
            binding.viewModel = viewModel
        }
    }
}