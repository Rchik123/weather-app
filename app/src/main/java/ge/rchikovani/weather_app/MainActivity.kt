package ge.rchikovani.weather_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    private lateinit var todayHourlyPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todayHourlyPager = findViewById(R.id.pager_today_hourly)
        todayHourlyPager.adapter = TodayHourlyPageAdapter(this)
    }
}