package com.tien.myweatherapp.data.db.network

import androidx.lifecycle.LiveData
import com.tien.myweatherapp.data.network.response.CurrentWeatherResponse

interface WeatherNetworkDataSource {
    val downloadCurrentWeather: LiveData<CurrentWeatherResponse>

    suspend fun fetchCurrentWeather(
        location: String,
        units: String
    )
}