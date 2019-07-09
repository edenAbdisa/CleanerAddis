package com.iyoa.cleanaddis.controller.report

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.iyoa.cleanaddis.MainActivity

import com.iyoa.cleanaddis.adapters.news.MyNewsRecyclerViewAdapter
import com.iyoa.cleanaddis.adapters.report.MyReportRecyclerViewAdapter
import com.iyoa.cleanaddis.controller.news.ArticleFragment
import com.iyoa.cleanaddis.data.news.Article

import com.iyoa.cleanaddis.data.report.Report
import com.iyoa.cleanaddis.retrofit.ArticleService
import com.iyoa.cleanaddis.retrofit.ArticleServiceImpl
import com.iyoa.cleanaddis.retrofit.ReportService
import com.iyoa.cleanaddis.retrofit.ReportServiceImpl
import com.iyoa.cleanaddis.utility.Connection
import com.iyoa.cleanaddis.viewModels.news.ArticleViewModel
import com.iyoa.cleanaddis.viewModels.report.ReportViewModel
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.recyclerview.widget.ItemTouchHelper
import android.R
import android.graphics.Canvas
import kotlinx.android.synthetic.main.fragment_report_list.*


/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [ReportFragment.OnListFragmentInteractionListener] interface.
 */
class ReportFragment : Fragment(),MyReportRecyclerViewAdapter.OnListFragmentInteractionListener {

    lateinit var reportViewModel: ReportViewModel
    val context = MainActivity()
    private var columnCount = 1
    private lateinit var  reportService: ReportService
    lateinit var recyclerView: RecyclerView

    override fun onListFragmentInteraction(item: Report) {
        //val articleFragment = ArticleDetailFragment()
        val args = Bundle()
        args.putSerializable("report",item)
        NavHostFragment.findNavController(this).navigate(com.iyoa.cleanaddis.R.id.action_report_list_to_report_detail, args)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val reportListAdapter = MyReportRecyclerViewAdapter(context,this)
        var reportList = reportListAdapter.getReports()

        val view = inflater.inflate(com.iyoa.cleanaddis.R.layout.fragment_report_list, container, false)



        recyclerView = view.findViewById(com.iyoa.cleanaddis.R.id.report_list)
        recyclerView.layoutManager = LinearLayoutManager(context)
        reportListAdapter.notifyDataSetChanged()

        recyclerView.adapter = reportListAdapter
        recyclerView.setHasFixedSize(true)



        if(Connection.checkConnection(view?.context)) {
            loadReports(reportListAdapter, reportList)
        }
        else{
            getReports(reportListAdapter)
        }

        return view
    }

    public fun swipe(){



    }

    private fun loadReports(reportListAdapter: MyReportRecyclerViewAdapter, reportList: List<Report>) {
        var reportList = reportList
        reportService = ReportServiceImpl().getReportServiceImpl()
        val call: Call<List<Report>> = reportService.getReportByUsername("Delilah14")
        call.enqueue(object: Callback<List<Report>> {
            override fun onResponse(call: Call<List<Report>>, response: Response<List<Report>>) {

                reportList = response.body() as List<Report>
                reportListAdapter.setReportsForApi(reportList)
                addReports(reportList)

                Log.println(Log.INFO, "ArticleLine81", reportList?.get(0).toString())
            }

            override fun onFailure(call: Call<List<Report>>, t:Throwable){
                Log.wtf("ArticleLine85",t.message)
            }

        })
    }

    private fun addReports(reportList: List<Report>) {
        reportViewModel = ViewModelProviders.of(this).get(
            ReportViewModel::class.java
        )

        reportViewModel.allReports.observe(this,androidx.lifecycle.Observer {
                reports->reports?.let{MyReportRecyclerViewAdapter(context,this).setReportsForApi(reports)}
        })
        run{
            reportViewModel.addReports(reportList)
        }


    }


    private fun getReports(reportListAdapter: MyReportRecyclerViewAdapter) {
        reportViewModel = ViewModelProviders.of(this).get(
            ReportViewModel::class.java
        )

        reportViewModel.allReports.observe(this,androidx.lifecycle.Observer {
                reports->reports?.let{reportListAdapter.setReportsForApi(reports)}
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        add_report_button.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(com.iyoa.cleanaddis.R.id.action_report_list_to_add_report)
        }
    }





    override fun onAttach(context: Context) {
        super.onAttach(context)


    }

    override fun onDetach() {
        super.onDetach()

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


}
