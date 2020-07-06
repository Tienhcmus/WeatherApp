@file:Suppress("DEPRECATION")

package com.tien.myweatherapp.ui.weather.current

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.tien.myweatherapp.R
import com.tien.myweatherapp.data.WeatherAPIService
import kotlinx.android.synthetic.main.current_weather_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception

class CurrentWeatherFragment : Fragment() {

    companion object {
        fun newInstance() = CurrentWeatherFragment()
    }

    private lateinit var viewModel: CurrentWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.current_weather_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CurrentWeatherViewModel::class.java)
        // TODO: Use the ViewModel
        val apiService = WeatherAPIService()

        GlobalScope.launch(Dispatchers.Main ) {
            val currentWeatherResponse = apiService.getCurrentWeather("Sai Gon").await()
            try {
                textview.text = currentWeatherResponse.currentWeatherEntry.toString()
            } catch (e: Exception){
                textview.text = "Cann't Request Data"
            }

        }
    }

}