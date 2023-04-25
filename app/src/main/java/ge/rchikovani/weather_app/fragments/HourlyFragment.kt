package ge.rchikovani.weather_app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ge.rchikovani.weather_app.R
import ge.rchikovani.weather_app.rv.adapters.HourlyAdapter
import ge.rchikovani.weather_app.rv.items.HourlyItem

class HourlyFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hourly, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerAdapter(view)
    }

    private fun setRecyclerAdapter(view: View) {
        // TODO temporary arraylist need to change after retrieving jsons
        val hourlyList = ArrayList<HourlyItem>()
        for (i in 0..20){
            val hourlyItem = HourlyItem("", "", "", "")
            hourlyList.add(hourlyItem)
        }

        val recyclerView: RecyclerView = view.findViewById(R.id.rv_hourly)
        recyclerView.adapter = HourlyAdapter("LONDON", hourlyList)
    }
}