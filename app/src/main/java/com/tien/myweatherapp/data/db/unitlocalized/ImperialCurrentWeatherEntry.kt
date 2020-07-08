package com.tien.myweatherapp.data.db.unitlocalized

import androidx.room.ColumnInfo

class ImperialCurrentWeatherEntry (
    @ColumnInfo(name = "Cloud")
    override val cloudcover: Double,
    @ColumnInfo(name = "Humidity")
    override val humidity: Double,
    @ColumnInfo(name = "isDay")
    override val isDay: String,
    @ColumnInfo(name = "observationTime")
    override val observationTime: String,
    @ColumnInfo(name = "precip_in")
    override val precip: Double,
    @ColumnInfo(name = "pressure")
    override val pressure: Double,
    @ColumnInfo(name = "temperature")
    override val temperature: Double,
    @ColumnInfo(name = "uvIndex")
    override val uvIndex: Double,
    @ColumnInfo(name = "weatherCode")
    override val weatherCode: Double,
    @ColumnInfo(name = "windDir")
    override val windDir: String,
    @ColumnInfo(name = "windSpeed")
    override val windSpeed: Double
): UnitCurrentWeatherEntry