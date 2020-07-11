package com.tien.myweatherapp.data.network.response


import com.google.gson.annotations.SerializedName
import com.tien.myweatherapp.data.db.entity.CurrentWeatherEntry
import com.tien.myweatherapp.data.db.entity.Location
import com.tien.myweatherapp.data.db.entity.Request

data class CurrentWeatherResponse(
    val location: Location,
    val request: Request,
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry

)