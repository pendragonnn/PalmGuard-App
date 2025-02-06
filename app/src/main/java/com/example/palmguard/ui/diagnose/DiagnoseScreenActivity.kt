package com.example.palmguard.ui.diagnose

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.palmguard.ui.diseaseDetail.DetailExplanationScreenActivity
import com.example.palmguard.R
import com.example.palmguard.databinding.ActivityDiagnoseScreenBinding
import com.example.palmguard.foundation.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class DiagnoseScreenActivity : AppCompatActivity() {
    private lateinit var bindingDiagnose: ActivityDiagnoseScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        bindingDiagnose = ActivityDiagnoseScreenBinding.inflate(layoutInflater)
        setContentView(bindingDiagnose.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        bindingDiagnose.vpDiagnose.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(bindingDiagnose.tlDiagnose, bindingDiagnose.vpDiagnose) { tab, position ->
            when(position) {
                0 -> tab.text = "Diagnose"
                1 -> tab.text = "Recommendation"
            }
        }.attach()

        bindingDiagnose.btDiagnoseResultInformation.setOnClickListener {
            Intent(this, DetailExplanationScreenActivity::class.java).also {
                startActivity(it)
            }
        }

        bindingDiagnose.btDiagnoseBack.setOnClickListener {
            finish()
        }
    }
}