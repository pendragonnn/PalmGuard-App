package com.example.palmguard.ui.errorDetection

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.palmguard.R
import com.example.palmguard.databinding.ActivityErrorDetectionScreenBinding

class ErrorDetectionScreenActivity : AppCompatActivity() {
    private lateinit var bindingErrorDetection: ActivityErrorDetectionScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        bindingErrorDetection = ActivityErrorDetectionScreenBinding.inflate(layoutInflater)
        setContentView(bindingErrorDetection.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        bindingErrorDetection.btErrorBack.setOnClickListener {
            finish()
        }
    }
}