package com.tien.myweatherapp.data.db.entity


import androidx.room.*
import com.google.gson.annotations.SerializedName

const val CURRENT_WEATHER_ID = 0
@Entity(tableName = "current_weather")
data class CurrentWeatherEntry(
    var cloudcover: Double,
    var humidity: Double,
    var temperature: Double,
    @SerializedName("uv_index")
    val uvIndex: Double,
    var visibility: Double,
    @SerializedName("weather_code")
    var weatherCode: Int,
    @SerializedName("weather_descriptions")
    var weatherDescriptions: List<String>,
    @SerializedName("weather_icons")
    var weatherIcons: List<String>,
    @SerializedName("wind_degree")
    var windDegree: Double,
    @SerializedName("wind_dir")
    var windDir: String,
    @SerializedName("wind_speed")
    var windSpeed: Double
)
{
    @PrimaryKey(autoGenerate = false)
    var id: Int = CURRENT_WEATHER_ID
}