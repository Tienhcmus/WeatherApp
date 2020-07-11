package com.tien.myweatherapp.data.db.unitlocalized

interface UnitSpecificCurrentWeatherEntry {
    val cloudcover: Double
    val humidity: Double
    val temperature: Double
   val uv_index: Double
    val visibility: Double
    val weatcode: Int
    val weatdescrip: String
    val weaticon: String
    val windDegree: Double
    val windDir: String
    val windSpeed: Double

}