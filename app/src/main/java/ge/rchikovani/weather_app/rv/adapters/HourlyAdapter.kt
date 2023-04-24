package ge.rchikovani.weather_app.rv.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ge.rchikovani.weather_app.R
import ge.rchikovani.weather_app.rv.items.HourlyItem

class HourlyAdapter(
    val cityName: String,
    val hourlyList: ArrayList<HourlyItem>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val VIEW_TYPE_COUNTRY = 0
    private val VIEW_TYPE_HOURLY = 1
    override fun getItemViewType(position: Int): Int {
        return if (position == 0){
            VIEW_TYPE_COUNTRY
        } else {
            VIEW_TYPE_HOURLY
        }
    }

    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_COUNTRY) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.countries_layout, parent, false)
            CountryViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.hourly_item, parent, false)
            HourlyViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == VIEW_TYPE_COUNTRY){
            val countryHolder: CountryViewHolder = holder as CountryViewHolder
            countryHolder.tvCity.text = cityName
        } else {
//            val hourlyHolder: HourlyViewHolder = holder as HourlyViewHolder
//            val hourly = hourlyList[position - 1]
//            hourlyHolder.tvDate.text = hourly.date
//            hourlyHolder.tvTemperature.text = hourly.temperature
//            hourlyHolder.tvDescription.text = hourly.description
        }
    }

    override fun getItemCount(): Int {
        return hourlyList.size + 1
    }
}

class CountryViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val tvCity: TextView = view.findViewById(R.id.tv_city)
}

class HourlyViewHolder(view: View): RecyclerView.ViewHolder(view){
    val tvDate: TextView = view.findViewById(R.id.tv_date)
    val tvTemperature: TextView = view.findViewById(R.id.tv_hourly_temp)
    val tvDescription: TextView = view.findViewById(R.id.tv_hourly_desc)
}

