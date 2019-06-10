package com.iyoa.cleanaddis.controller.report

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.iyoa.cleanaddis.R
import com.iyoa.cleanaddis.adapters.report.MyReportRecyclerViewAdapter

import com.iyoa.cleanaddis.controller.report.dummy.DummyContent
import com.iyoa.cleanaddis.data.report.Report
import com.iyoa.cleanaddis.retrofitDelilah.ArticleService

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [ReportFragment.OnListFragmentInteractionListener] interface.
 */
class ReportFragment : Fragment() {

    // TODO: Customize parameters
    private var columnCount = 1

    private var listener: OnListFragmentInteractionListener? = null
    private lateinit var  articleService: ArticleService

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_report_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = MyReportRecyclerViewAdapter(DummyContent.ITEMS, listener)
            }
        }
        view.findViewById<View>(R.id.report_cardview).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_report_list_to_report_detail)
        }
        view.findViewById<View>(R.id.add_report_button).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_report_list_to_add_report)
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
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
     * See the Android Training lesson
     * [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onListFragmentInteraction(item: Report)
    }

}
