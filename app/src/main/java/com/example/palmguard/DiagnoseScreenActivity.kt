package com.example.palmguard

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class DiagnoseScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_diagnose_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val vp_diagnose: ViewPager2 = findViewById(R.id.vp_diagnose)
        val tl_diagnose: TabLayout = findViewById(R.id.tl_diagnose)

        vp_diagnose.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(tl_diagnose, vp_diagnose) { tab, position ->
            when(position) {
                0 -> tab.text = "Diagnose"
                1 -> tab.text = "Recommendation"
            }
        }.attach()

    }
}