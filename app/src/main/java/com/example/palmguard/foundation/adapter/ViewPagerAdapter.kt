package com.example.palmguard.foundation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.palmguard.ui.diagnose.DiagnoseFragment
import com.example.palmguard.ui.diagnose.RecommendationFragment

class ViewPagerAdapter(fa: FragmentActivity): FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> DiagnoseFragment()
            1 -> RecommendationFragment()
            else -> DiagnoseFragment()
        }
    }
}