package ge.rchikovani.weather_app.json

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("weather")
    fun getCurrentWeather(@Query("q") cityName: String,
                          @Query("appid") apiKey: String,
                          @Query("units") units: String)
    : Call<CurrentWeatherModel>
}