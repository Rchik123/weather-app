package ge.rchikovani.weather_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    private lateinit var btnToday: ImageButton
    private lateinit var btnHourly: ImageButton
    private lateinit var todayHourlyPager: ViewPager2

    private val TODAY_PAGE_NUM = 0
    private val HOURLY_PAGE_NUM = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todayHourlyPager = findViewById(R.id.pager_today_hourly)
        todayHourlyPager.adapter = TodayHourlyPagerAdapter(this)

        configureButtons()
    }

    private fun configureButtons(){
        btnToday = findViewById(R.id.ib_today)
        btnHourly = findViewById(R.id.ib_hourly)

        btnToday.setOnClickListener {
            todayHourlyPager.setCurrentItem(TODAY_PAGE_NUM, true)
        }

        btnHourly.setOnClickListener {
            todayHourlyPager.setCurrentItem(HOURLY_PAGE_NUM, true)
        }
    }
}