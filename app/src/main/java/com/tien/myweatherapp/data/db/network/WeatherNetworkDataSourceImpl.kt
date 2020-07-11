package com.tien.myweatherapp.data.db.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tien.myweatherapp.data.WeatherAPIService
import com.tien.myweatherapp.data.network.response.CurrentWeatherResponse
import com.tien.myweatherapp.internal.NoConnectivityException

class WeatherNetworkDataSourceImpl (
    private val WeatherApiService : WeatherAPIService
): WeatherNetworkDataSource {

    private val _downloadCurrentWeather = MutableLiveData<CurrentWeatherResponse>()

    override val downloadCurrentWeather: LiveData<CurrentWeatherResponse>
        get() = _downloadCurrentWeather

    override suspend fun fetchCurrentWeather(location: String, units: String) {
        try {
            val fetchedCurrentWeather = WeatherApiService
                .getCurrentWeather(location, units)
                .await()
            _downloadCurrentWeather.postValue(fetchedCurrentWeather)
        } catch (e: NoConnectivityException){
            Log.e("Connectivity", "No Internet Connection ", e)
        }
    }
}