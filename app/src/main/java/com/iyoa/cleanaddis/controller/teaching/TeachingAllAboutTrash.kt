package com.iyoa.cleanaddis.controller.teaching


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.teaching_all_about_trash.view.*
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.iyoa.cleanaddis.R


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */



class TeachingAllAboutTrash : Fragment() {
    private val myContext: FragmentActivity? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.teaching_all_about_trash, container, false)

        val sendAbtButton=view.AllAboutButton
        sendAbtButton.setOnClickListener {

/*
val ft = childFragmentManager
            .beginTransaction()
            .replace(containerViewId, fragment)

        if (!childFragmentManager.isStateSaved) {
            ft.commit()
        } else if (allowStateLoss) {
            ft.commitAllowingStateLoss()
        }
 */
            val ABTFragment = RecyclerViewAllAboutTrash()
            val l=childFragmentManager.beginTransaction()


              val o=l.replace(view.frameFirst.id, ABTFragment)
            Toast.makeText(context,"here3",Toast.LENGTH_LONG).show()

               o.commit()
        }



        return view


    }









}