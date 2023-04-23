package ge.rchikovani.weather_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ge.rchikovani.weather_app.rv.items.DetailItem
import ge.rchikovani.weather_app.rv.items.OverviewItem

class TodayFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_today, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerAdapter(view)
    }

    private fun setRecyclerAdapter(view: View) {
        val detailList = arrayListOf<DetailItem>().apply {
            add(DetailItem("Temperature", "5*"))
            add(DetailItem("Feels Like", "3*"))
            add(DetailItem("Humidity", "74%"))
            add(DetailItem("Pressure", "1010"))
        }
        val overview = OverviewItem("LONDON", "5*", "BROKEN CLOUDS", null)
        view.findViewById<RecyclerView>(R.id.rv_today).adapter = TodayAdapter(overview, detailList)
    }
}