package ge.rchikovani.weather_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ge.rchikovani.weather_app.rv.items.DetailItem
import ge.rchikovani.weather_app.rv.items.OverviewItem

class TodayAdapter(
    val overview: OverviewItem,
    val detailList: ArrayList<DetailItem>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val VIEW_TYPE_OVERVIEW = 0
    private val VIEW_TYPE_DETAIL = 1
    override fun getItemViewType(position: Int): Int {
        return if (position == 0){
            VIEW_TYPE_OVERVIEW
        } else {
            VIEW_TYPE_DETAIL
        }
    }

    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_OVERVIEW) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.overview_item, parent, false)
            OverviewViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.details_item, parent, false)
            DetailViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == VIEW_TYPE_OVERVIEW){
            val overviewHolder: OverviewViewHolder = holder as OverviewViewHolder
            overviewHolder.tvCity.text = overview.cityName
            overviewHolder.tvDegree.text = overview.degree
            overviewHolder.tvDescription.text = overview.description
        } else {
            val detailHolder: DetailViewHolder = holder as DetailViewHolder
            val detail = detailList[position - 1]
            detailHolder.tvDetailName.text = detail.detailName
            detailHolder.tvDetailValue.text = detail.detailValue
        }
    }

    override fun getItemCount(): Int {
        return detailList.size + 1
    }
}

class OverviewViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val tvCity: TextView = view.findViewById(R.id.tv_city)
    val tvDegree: TextView = view.findViewById(R.id.tv_degree)
    val tvDescription: TextView = view.findViewById(R.id.tv_weather_desc)
}

class DetailViewHolder(view: View): RecyclerView.ViewHolder(view){
    val tvDetailName: TextView = view.findViewById(R.id.tv_detail_name)
    val tvDetailValue: TextView = view.findViewById(R.id.tv_detail_value)
}

