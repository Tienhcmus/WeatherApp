package com.tien.myweatherapp.data.db.unitlocalized

import androidx.room.Embedded
import com.google.gson.annotations.SerializedName

interface UnitCurrentWeatherEntry {
    val cloudcover: Double
    val humidity: Double
    val isDay: String
    val observationTime: String
    val precip: Double
    val pressure: Double
    val temperature: Double
    val uvIndex: Double
    val weatherCode: Double
    val windDir: String
    val windSpeed: Double
}