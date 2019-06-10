package com.iyoa.cleanaddis.adapters.teaching

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iyoa.cleanaddis.R
import com.iyoa.cleanaddis.data.common.Category

class TeachingRecyclerViewAdapter(val context: Context):
    RecyclerView.Adapter<TeachingRecyclerViewAdapter.CategoryViewHolder>() {

    private var category:List<Category> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):CategoryViewHolder {
        val recyclerItem= LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_recyclerviewforrec, parent, false)
    recyclerItem.setOnClickListener {  }
        return CategoryViewHolder(recyclerItem)
    }

    override fun getItemCount(): Int =category.size

    override fun onBindViewHolder(holder: TeachingRecyclerViewAdapter.CategoryViewHolder, position: Int) {

    val categoryeach: Category=category.get(position)



    }


   inner class CategoryViewHolder(val recView: View):RecyclerView.ViewHolder(recView){



   }

}