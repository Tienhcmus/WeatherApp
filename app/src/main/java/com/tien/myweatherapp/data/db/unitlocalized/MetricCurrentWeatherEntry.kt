package com.tien.myweatherapp.data.db.unitlocalized

import androidx.room.ColumnInfo
import androidx.room.TypeConverters

data class MetricCurrentWeatherEntry (
    @ColumnInfo(name = "cloudcover")
    override val cloudcover: Double,
    @ColumnInfo(name = "humidity")
    override val humidity: Double,
    @ColumnInfo(name = "temperature")
    override val temperature: Double,
    @ColumnInfo(name = "uvIndex")
    override val uv_index: Double,
    @ColumnInfo(name = "visibility")
    override val visibility: Double,
    @ColumnInfo(name = "weatherCode")
    override val weatcode: Int,
    @ColumnInfo(name = "weatherDescriptions")
    override val weatdescrip: String,
    @ColumnInfo(name = "weatherIcons")
    override val weaticon: String,
    @ColumnInfo(name = "windDegree")
    override val windDegree: Double,
    @ColumnInfo(name = "windDir")
    override val windDir: String,
    @ColumnInfo(name = "windSpeed")
    override val windSpeed: Double
):UnitSpecificCurrentWeatherEntry