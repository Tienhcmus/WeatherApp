package com.tien.myweatherapp.data.db.repository

import androidx.lifecycle.LiveData
import com.tien.myweatherapp.data.db.unitlocalized.UnitSpecificCurrentWeatherEntry


interface ForecastRepository {
     suspend fun getCurrentWeather(metric: Boolean): LiveData<out UnitSpecificCurrentWeatherEntry>
}