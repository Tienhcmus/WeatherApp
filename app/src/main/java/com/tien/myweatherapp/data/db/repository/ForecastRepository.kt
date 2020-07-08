package com.tien.myweatherapp.data.db.repository

import androidx.lifecycle.LiveData
import com.tien.myweatherapp.data.db.unitlocalized.UnitCurrentWeatherEntry


interface ForecastRepository {
     suspend fun getCurrentWeather(): LiveData<out UnitCurrentWeatherEntry>
}