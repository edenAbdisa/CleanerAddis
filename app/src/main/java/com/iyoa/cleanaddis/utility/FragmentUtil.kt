package com.iyoa.cleanaddis.utility

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Adapter
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.iyoa.cleanaddis.R
import com.iyoa.cleanaddis.data.news.Article


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


