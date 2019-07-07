package com.iyoa.cleanaddis.controller.posting

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.iyoa.cleanaddis.R
import kotlinx.android.synthetic.main.fragment_post.*
import kotlinx.android.synthetic.main.fragment_post.view.*


class PostFragment : Fragment() {
    private var columnCount = 1
    lateinit var recyclerView:RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        val view= inflater.inflate(R.layout.fragment_post, container, false)

        // view.textView_current_action_title.setText(R.string.title_home)
        // view.navigation_bottom_bar.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        // Navigation.findNavController(it).navigate(R.id.next_action)
        val navController = this.findNavController()
        view.navigation_bottom_bar?.let {
            NavigationUI.setupWithNavController(it, navController)}


        return view
    }


    fun replaceChildFragmenty(fragment: Fragment,allowStateLoss: Boolean = false, @IdRes containerViewId: Int) {

        val ft = childFragmentManager
            .beginTransaction()
            .replace(containerViewId, fragment)

        if (!childFragmentManager.isStateSaved) {
            ft.commit()
        } else if (allowStateLoss) {
            ft.commitAllowingStateLoss()
        }
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.displayPostsRecyclerViewFragment -> {
                //   textView_current_action_title.setText(R.string.title_home)
                /*  replaceChildFragmenty(
                      DisplayPostsRecyclerViewFragment(),
                      true,
                      R.id.linearLayout_front_post_view
                  )*/
                // Navigation.findNavController(view!!.findViewById(R.id.nav_post_fragments_display)).navigate(R.id.action_postFragment_to_displayPostsRecyclerViewFragment)
                // this.findNavController().navigate(R.id.action_postFragment_to_displayPostsRecyclerViewFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.postAccountFragment -> {
                //  textView_current_action_title.setText(R.string.title_dashboard)
                // Navigation.findNavController(view!!.findViewById(R.id.nav_post_fragments_display)).navigate(R.id.action_postFragment_to_postAccountFragment)
                /* replaceChildFragmenty(
                     PostAccountFragment(),
                     true,
                     R.id.linearLayout_front_post_view
                 )*/
                // this.findNavController().navigate(R.id.action_postFragment_to_postAccountFragment,null)

                return@OnNavigationItemSelectedListener true
            }
            R.id.selectPictureToPostFragment -> {
                // Navigation.findNavController(view!!.findViewById(R.id.nav_post_fragments_display)).navigate(R.id.action_postFragment_to_selectPictureToPostFragment)
                // textView_current_action_title.setText(R.string.title_notifications)
                /*replaceChildFragmenty(
                    SelectPictureToPostFragment(),
                    true,
                    R.id.linearLayout_front_post_view
                )*/
                // this.findNavController().navigate(R.id.action_postFragment_to_selectPictureToPostFragment,null)

                return@OnNavigationItemSelectedListener true
            }

        }
        false
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onDetach() {
        super.onDetach()
    }


}
