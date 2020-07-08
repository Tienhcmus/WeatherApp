package com.tien.myweatherapp.ui.weather.current

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.tien.myweatherapp.R
import com.tien.myweatherapp.ui.base.ScopeFragment
import kotlinx.android.synthetic.main.current_weather_fragment.*
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class CurrentWeatherFragment : ScopeFragment(), KodeinAware {

    override val kodein by closestKodein()

    private val viewModelFactory: CurrentWeatherViewFactory by instance()


    private lateinit var viewModel: CurrentWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.current_weather_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        @Suppress("DEPRECATION")
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(CurrentWeatherViewModel::class.java)

        bindUI()

//        val weatherAPI = WeatherAPIService(ConnectivityInterceptorImpl(this.requireContext()))
//        val weatherNetworkDataSource = WeatherNetworkDataSourceImpl(weatherAPI)
//
//        weatherNetworkDataSource.downloadCurrentWeather.observe(this.viewLifecycleOwner, Observer { textview.text = it.toString() })
//
//        GlobalScope.launch(Dispatchers.Main ) {
//            weatherNetworkDataSource.fetchCurrentWeather("London")
//        }
    }
    @SuppressLint("FragmentLiveDataObserve")
    private fun bindUI() = launch{
        val currentWeather = viewModel.weather.await()
        currentWeather.observe(this@CurrentWeatherFragment, Observer {
            if(it == null) return@Observer
            textview.text = it.toString()
        })
    }

}