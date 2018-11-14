package com.kotlin.insane.kpassignment.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kotlin.insane.kpassignment.R
import com.kotlin.insane.kpassignment.databinding.ItemWeatherBinding
import com.kotlin.insane.kpassignment.model.WeatherList
import com.kotlin.insane.kpassignment.ui.main.MainListViewModel
import com.kotlin.insane.kpassignment.util.iconUrl
import kotlinx.android.synthetic.main.item_weather.view.*

class WeatherAdapter: RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {
    private lateinit var weatherList: List<WeatherList>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherAdapter.ViewHolder {
        val binding: ItemWeatherBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_weather, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.run {
            Glide.with(context)
                .load(iconUrl + weatherList[position].weather.get(0).icon + ".png")
                .into(list_img)
        }

        holder.bind(weatherList[position])
    }

    override fun getItemCount(): Int {
        return if(::weatherList.isInitialized) weatherList.size else 0
    }

    fun updateWeatherList(weatherList: List<WeatherList>) {
        this.weatherList = weatherList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemWeatherBinding): RecyclerView.ViewHolder(binding.root) {
        private val viewModel = MainListViewModel()

        fun bind(weatherList: WeatherList) {
            viewModel.bind(weatherList)
            binding.viewModel = viewModel
        }
    }
}