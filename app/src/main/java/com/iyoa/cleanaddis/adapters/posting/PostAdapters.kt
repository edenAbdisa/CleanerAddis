package com.iyoa.cleanaddis.adapters.posting

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.iyoa.cleanaddis.R
import com.iyoa.cleanaddis.entity.posting.Post
import kotlinx.android.synthetic.main.single_post_display.view.*

class PostAdapters (val context: Context) : RecyclerView.Adapter<PostAdapters.PostViewHolder>() {

    private val mValues = listOf(

        Post("Software Engineering II", "ITSE-3212",7,"Software Engineering II description"),
        Post("Advanced Mobile Programming", "ITSE-3223",7,"Advanced Mobile Programming description"),
        Post("Operating System", "ITSE-3253",7,"Operating System description")
    )
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val recyclerViewItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_post_display, parent, false)
        recyclerViewItem.setOnClickListener{}
        return PostViewHolder(recyclerViewItem)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val item = mValues[position]
        holder.username.text = item.username
        holder.likedBy.text = item.noLike.toString()
        holder.postDescription.text=item.mediaPath


    }

    override fun getItemCount(): Int = mValues.size

    inner class PostViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val username: TextView = mView.textView_username
        val likedBy: TextView = mView.textView_liked_by
        val postDescription: TextView = mView.textView_post_description


        }


    }

