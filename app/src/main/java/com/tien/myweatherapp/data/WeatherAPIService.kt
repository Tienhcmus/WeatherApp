package com.tien.myweatherapp.data

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.tien.myweatherapp.data.db.network.response.CurrentWeatherResponse
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "b5d681d9bca98558b6ce0274cd3749ff"

//http://api.weatherstack.com/current?access_key=b5d681d9bca98558b6ce0274cd3749ff&query=New%20York

interface WeatherAPIService {

    @GET("current")
    fun getCurrentWeather(
        @Query("query") location: String
    ):Deferred<CurrentWeatherResponse>
    companion object{
        operator fun invoke(): WeatherAPIService{
            val requestInterceptor = Interceptor{chain ->
                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("access_key", API_KEY)
                    .build()

                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor chain.proceed(request)
            }
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()

            val retrofit = Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://api.weatherstack.com/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

                return retrofit.create(WeatherAPIService::class.java)
        }
    }

}