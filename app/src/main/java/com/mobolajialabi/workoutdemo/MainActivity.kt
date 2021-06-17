package com.mobolajialabi.workoutdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tab : TabLayout = findViewById(R.id.tab)
        val pager : ViewPager2 = findViewById(R.id.vp)

        pager.adapter = VPAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(tab, pager) { tab, position ->
            tab.text = when(position) {
                0 -> getString(R.string.today)
                1 -> getString(R.string.next)
                2 -> getString(R.string.month)
                else -> getString(R.string.today)
            }
        }.attach()
    }
}