package com.tien.myweatherapp.ui.weather.current

import androidx.lifecycle.ViewModel
import com.tien.myweatherapp.data.db.repository.ForecastRepository
import com.tien.myweatherapp.internal.lazyDeferred

class CurrentWeatherViewModel (
    private val forecastRepository: ForecastRepository
) : ViewModel() {
    val weather by lazyDeferred{
        forecastRepository.getCurrentWeather()
    }


}