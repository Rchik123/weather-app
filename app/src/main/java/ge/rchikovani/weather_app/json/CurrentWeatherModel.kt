package ge.rchikovani.weather_app.json

data class CurrentWeatherModel(
    val weather: ArrayList<WeatherModel>,
    val main: MainModel
)

data class WeatherModel(
    val description: String,
    val icon: String,
)

data class MainModel(
    val feels_like: Double,
    val humidity: Int,
    val pressure: Int,
    val temp: Double,
)