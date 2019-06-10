package com.iyoa.cleanaddis.adapters.report

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.iyoa.cleanaddis.R


import com.iyoa.cleanaddis.controller.report.ReportFragment.OnListFragmentInteractionListener
import com.iyoa.cleanaddis.controller.report.dummy.DummyContent.DummyItem
import com.iyoa.cleanaddis.data.report.Report

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class MyReportRecyclerViewAdapter(
    private val mValues: List<Report>,
    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<MyReportRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as Report
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_report, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        /*
        holder.mIdView.text = item.id
        holder.mContentView.text = item.content
        */


        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        /*val mIdView: TextView = mView.item_number
        val mContentView: TextView = mView.content
        */

        override fun toString(): String {
           return super.toString() + " '" + "'"
        }
    }
}
