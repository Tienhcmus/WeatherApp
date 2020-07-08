package com.tien.myweatherapp.data.db.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tien.myweatherapp.data.WeatherAPIService
import com.tien.myweatherapp.data.db.entity.CurrentWeatherEntry
import com.tien.myweatherapp.data.db.network.response.CurrentWeatherResponse
import com.tien.myweatherapp.internal.NoConnectivityException

class WeatherNetworkDataSourceImpl (
    private val weatherAPI : WeatherAPIService
) : WeatherNetworkDataSource {

    private val _downloadCurrentWeather = MutableLiveData<CurrentWeatherResponse>()
    override val downloadCurrentWeather: LiveData<CurrentWeatherResponse>
        get() = _downloadCurrentWeather

    override suspend fun fetchCurrentWeather(location: String) {
        try {
            val fetchedCurrentWeather = weatherAPI.getCurrentWeather(location).await()
            _downloadCurrentWeather.postValue(fetchedCurrentWeather)
        } catch (e: NoConnectivityException){
            Log.e("Connectivity", "No Internet Connection", e)
        }
    }
}