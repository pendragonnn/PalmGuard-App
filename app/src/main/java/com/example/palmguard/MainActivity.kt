package com.example.palmguard

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.palmguard.ui.history.FragmentHistoryScreen
import com.example.palmguard.ui.home.FragmentHomeScreen
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

//        val cv_history = findViewById<CardView>(R.id.cv_history)
//        cv_history.setOnClickListener{
//            Intent(this, DiagnoseScreenActivity::class.java).also{
//                startActivity(it)
//            }
//        }

        replaceFragment(FragmentHomeScreen())

        val homeBottomNav = findViewById<BottomNavigationView>(R.id.bnv_home)
        homeBottomNav.setOnItemSelectedListener{ menuItem ->
            when(menuItem.itemId) {
                R.id.home -> replaceFragment(FragmentHomeScreen())
                R.id.history -> replaceFragment(FragmentHistoryScreen())
                else -> {

                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_homescreen,fragment)
        fragmentTransaction.commit()
    }
}