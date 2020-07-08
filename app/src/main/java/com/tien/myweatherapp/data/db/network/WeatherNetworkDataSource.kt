package com.tien.myweatherapp.data.db.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tien.myweatherapp.data.db.entity.CurrentWeatherEntry
import com.tien.myweatherapp.data.db.network.response.CurrentWeatherResponse

interface WeatherNetworkDataSource {

    val downloadCurrentWeather: LiveData<CurrentWeatherResponse>

    suspend fun fetchCurrentWeather(
        location: String
    )
}