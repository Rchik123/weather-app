package ge.rchikovani.weather_app

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TodayHourlyPageAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    private val fragments = arrayListOf(TodayFragment(), HourlyFragment())

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}