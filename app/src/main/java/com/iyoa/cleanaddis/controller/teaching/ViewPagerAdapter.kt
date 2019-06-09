package com.example.abigail.myapplication

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        when(position){

            0-> return TeachingAllAboutTrash()
            1 -> return TeachingRecyclable()
            2 -> return TeachingNonRecyclable()
        }
        return TeachingAllAboutTrash()
    }

    override fun getCount(): Int {
        return 3
    }
}