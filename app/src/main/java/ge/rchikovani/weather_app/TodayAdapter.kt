package ge.rchikovani.weather_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TodayAdapter: RecyclerView.Adapter<TodayItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodayItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.today_item, parent, false)
        return TodayItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodayItemViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 1
    }
}

class TodayItemViewHolder(view: View): RecyclerView.ViewHolder(view) {

}