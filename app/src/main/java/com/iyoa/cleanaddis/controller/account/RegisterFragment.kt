package com.iyoa.cleanaddis.controller.account


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation

import com.iyoa.cleanaddis.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class RegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        view.findViewById<View>(R.id.check_imageview).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_signup_to_account_setting)
        }
        view.findViewById<View>(R.id.account_signin_button).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_signin_to_account_setting)
        }
        return view
    }


}
