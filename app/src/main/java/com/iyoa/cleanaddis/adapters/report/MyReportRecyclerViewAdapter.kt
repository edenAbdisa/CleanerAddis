package com.iyoa.cleanaddis.adapters.report

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView



import com.iyoa.cleanaddis.controller.report.dummy.DummyContent.DummyItem
import com.iyoa.cleanaddis.data.report.Report
import kotlinx.android.synthetic.main.fragment_news.view.*
import kotlinx.android.synthetic.main.fragment_report.view.*
import android.R



/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class MyReportRecyclerViewAdapter(
    val context: Context,private val listener: OnListFragmentInteractionListener

) : RecyclerView.Adapter<MyReportRecyclerViewAdapter.ViewHolder>() {
    private var reports: List<Report> = emptyList()
    private var itemListen: OnListFragmentInteractionListener? = null
    private lateinit var contexts: Context



    internal fun getReports():List<Report>{
        return reports
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(com.iyoa.cleanaddis.R.layout.fragment_report, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = reports[position]
        /*
        holder.mIdView.text = item.id
        holder.mContentView.text = item.content
        */
        val course: Report = reports.get(position)
        //Log.wtf("ArticleLine35",course.subject)

        holder.mTitle.text = course.subject
        holder.mSummary.text = course.username
        holder.mView.setOnClickListener {
            listener.onListFragmentInteraction(reports[position])
        }



    }
    fun removeItem(position: Int) {

        notifyItemRemoved(position)
    }

    override fun getItemCount(): Int = reports.size

    internal fun setReportsForApi(reports: List<Report>){
        this.reports = reports
        notifyDataSetChanged()
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        /*val mIdView: TextView = mView.item_number
        val mContentView: TextView = mView.content
        */
        val mTitle: TextView = mView.report_title_textview
        val mSummary: TextView = mView.report_summary_textview
        //val mViewButton: Button = mView.view_button_news

        override fun toString(): String {
           return super.toString() + " '" + "'"
        }
    }

    interface OnListFragmentInteractionListener {

        fun onListFragmentInteraction(item: Report)
    }
}
