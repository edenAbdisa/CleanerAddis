package com.example.abigail.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iyoa.cleanaddis.R


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [TeachingNonRecyclable.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [TeachingNonRecyclable.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class TeachingNonRecyclable : Fragment() {
    // TODO: Rename and change types of parameters



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.teaching_nonrecycleable, container, false)

        return view
    }

}
