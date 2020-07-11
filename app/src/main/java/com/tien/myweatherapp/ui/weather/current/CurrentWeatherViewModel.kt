package com.tien.myweatherapp.ui.weather.current

import androidx.lifecycle.ViewModel
import com.tien.myweatherapp.data.db.ForecastDatabase
import com.tien.myweatherapp.data.db.repository.ForecastRepository
import com.tien.myweatherapp.internal.UnitSystem
import com.tien.myweatherapp.internal.UnitSystem.METRIC
import com.tien.myweatherapp.internal.lazyDeferred

class CurrentWeatherViewModel (
    private val forecastRepository: ForecastRepository
): ViewModel() {
    private val unitSystem = UnitSystem.METRIC

    val isMetric: Boolean
        get() = unitSystem == METRIC

    val weather by lazyDeferred {
        forecastRepository.getCurrentWeather(isMetric)
    }
}