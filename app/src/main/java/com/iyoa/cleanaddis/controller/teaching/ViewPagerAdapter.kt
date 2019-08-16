package com.iyoa.cleanaddis.controller.teaching

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

<<<<<<< HEAD
class ViewPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {
=======
class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
>>>>>>> 1e134995d476569c612b5ed24358e3472a76afe0
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