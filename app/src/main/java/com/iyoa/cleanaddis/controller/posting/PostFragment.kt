package com.iyoa.cleanaddis.controller.posting

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.iyoa.cleanaddis.R
import kotlinx.android.synthetic.main.fragment_post.*
import kotlinx.android.synthetic.main.fragment_post.view.*


class PostFragment() : Fragment() {
    private var columnCount = 1
    private var listener: OnFragmentInteractionListener? = null

    lateinit var recyclerView:RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {

        val view= inflater.inflate(R.layout.fragment_post, container, false)

        view.navigation_bottom_bar.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        return view
    }
    fun replaceChildFragmenty(fragment: Fragment,
                                           allowStateLoss: Boolean = false,
                                           @IdRes containerViewId: Int) {

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
            R.id.navigation_home -> {
                textView_current_action_title.setText(R.string.title_home)

                replaceChildFragmenty(
                    DisplayPostsRecyclerViewFragment(),
                    true,
                    R.id.linearLayout_front_post_view
                )

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_account -> {
                textView_current_action_title.setText(R.string.title_dashboard)
                replaceChildFragmenty(
                    PostAccountFragment(),
                    true,
                    R.id.linearLayout_front_post_view
                )

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_add_image -> {
                textView_current_action_title.setText(R.string.title_notifications)
                replaceChildFragmenty(
                    SelectPictureToPostFragment(),
                    true,
                    R.id.linearLayout_front_post_view
                )
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_setting -> {
                textView_current_action_title.setText(R.string.title_notifications)
                replaceChildFragmenty(
                    SelectPictureToPostFragment(),
                    true,
                    R.id.linearLayout_front_post_view
                )
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
      /*  if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }*/
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }


}
