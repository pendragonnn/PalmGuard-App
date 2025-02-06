package com.example.palmguard.ui.diseaseDetail

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.palmguard.R
import com.example.palmguard.databinding.ActivityDetailExplanationScreenBinding

class DetailExplanationScreenActivity : AppCompatActivity() {
    private lateinit var bindingDetailExplanation: ActivityDetailExplanationScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        bindingDetailExplanation = ActivityDetailExplanationScreenBinding.inflate(layoutInflater)
        setContentView(bindingDetailExplanation.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        bindingDetailExplanation.root.setPadding(16, 16, 16, 16)

        bindingDetailExplanation.btDetailExplanationBack.setOnClickListener {
            finish()
        }
    }
}