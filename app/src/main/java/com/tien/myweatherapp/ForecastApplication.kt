package com.tien.myweatherapp

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import com.tien.myweatherapp.data.WeatherAPIService
import com.tien.myweatherapp.data.db.ForecastDatabase
import com.tien.myweatherapp.data.db.network.ConnectivityInterceptor
import com.tien.myweatherapp.data.db.network.ConnectivityInterceptorImpl
import com.tien.myweatherapp.data.db.network.WeatherNetworkDataSource
import com.tien.myweatherapp.data.db.network.WeatherNetworkDataSourceImpl
import com.tien.myweatherapp.data.db.repository.ForecastRepository
import com.tien.myweatherapp.data.db.repository.ForecastRepositoryImpl
import com.tien.myweatherapp.ui.weather.current.CurrentWeatherViewFactory
import okhttp3.Interceptor
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class ForecastApplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy(){
        import(androidXModule(this@ForecastApplication))

        bind() from singleton { ForecastDatabase(instance()) }
        bind() from singleton { instance<ForecastDatabase>().currentWeatherDao() }
        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }
        bind() from singleton { WeatherAPIService(instance()) }
        bind<WeatherNetworkDataSource>() with singleton { WeatherNetworkDataSourceImpl(instance()) }
        bind<ForecastRepository>() with singleton {     ForecastRepositoryImpl(instance(), instance()) }
        bind() from provider { CurrentWeatherViewFactory(instance()) }
    }

    override fun onCreate(){
        super.onCreate()
        AndroidThreeTen.init(this)
    }
}