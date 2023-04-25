package ge.rchikovani.weather_app.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import ge.rchikovani.weather_app.R
import ge.rchikovani.weather_app.json.CurrentWeatherModel
import ge.rchikovani.weather_app.json.WeatherApi
import ge.rchikovani.weather_app.rv.adapters.TodayAdapter
import ge.rchikovani.weather_app.rv.items.DetailItem
import ge.rchikovani.weather_app.rv.items.OverviewItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TodayFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_today, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.rv_today)
        updateCurrentWeatherData()
    }

    private fun setRecyclerAdapter(recyclerView: RecyclerView, weatherData: CurrentWeatherModel) {

        val detailList = arrayListOf<DetailItem>().apply {
            add(DetailItem("Temperature", weatherData.main.temp.toString()))
            add(DetailItem("Feels Like", weatherData.main.feels_like.toString()))
            add(DetailItem("Humidity", weatherData.main.humidity.toString()))
            add(DetailItem("Pressure", weatherData.main.pressure.toString()))
        }
        val overview = OverviewItem(
            "TBILISI",
            weatherData.main.temp.toString(),
            weatherData.weather[0].description,
            null)
        recyclerView.adapter = TodayAdapter(overview, detailList)
    }

    private fun updateCurrentWeatherData() {
        var weatherData: CurrentWeatherModel? = null

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(WeatherApi::class.java)
        val currentWeatherCall = api.getCurrentWeather(
            "tbilisi",
            "51a18d3bb1ff90d7bd651bdea4f9ce3a",
            "metric"
        )

        currentWeatherCall.enqueue(object: Callback<CurrentWeatherModel>{
            override fun onResponse(
                call: Call<CurrentWeatherModel>,
                response: Response<CurrentWeatherModel>
            ) {
                if(response.isSuccessful){
                    weatherData = response.body()
                    weatherData?.let {
                        setRecyclerAdapter(recyclerView, it)
                    }
                }
            }

            override fun onFailure(call: Call<CurrentWeatherModel>, t: Throwable) {
                Toast.makeText(context, "Error: Failed to retrieve weather data", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }
}