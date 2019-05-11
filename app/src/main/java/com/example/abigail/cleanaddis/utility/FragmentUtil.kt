package com.example.abigail.cleanaddis.utility

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager




    fun AppCompatActivity.replaceFragmenty(fragment: Fragment,
                                           allowStateLoss: Boolean = false,
                                           @IdRes containerViewId: Int) {

        val ft = supportFragmentManager
            .beginTransaction()
            .replace(containerViewId, fragment)

        if (!supportFragmentManager.isStateSaved) {
            ft.commit()
        } else if (allowStateLoss) {
            ft.commitAllowingStateLoss()
        }
    }

