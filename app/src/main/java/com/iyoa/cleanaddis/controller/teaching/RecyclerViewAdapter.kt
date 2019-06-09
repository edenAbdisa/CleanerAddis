package com.iyoa.cleanaddis.controller.teaching

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iyoa.cleanaddis.R

class RecyclerViewAdapter(val context: Context): RecyclerView.Adapter<RecyclerViewAdapter.CategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    val inflater=LayoutInflater.from(parent.context)
        val recyclerViewItem=inflater.inflate(R.layout.singlecategorypage,parent,false)
        return CategoryViewHolder(recyclerViewItem)
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class CategoryViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)



}