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

class PostAdapters (val context: Context,val post:List<Post>) : RecyclerView.Adapter<PostAdapters.PostViewHolder>() {

    private val mValues = post
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val recyclerViewItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_post_display, parent, false)
        recyclerViewItem.setOnClickListener{}
        return PostViewHolder(recyclerViewItem)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val item = mValues[position]
        //add a listener that will allow to delete the post
        //to item after checking if the currently logged user is equal to item.username
        holder.username.text = item.username
        holder.likedBy.text = item.noLike.toString()
        holder.postDescription.text=item.mediaUuid.toString()


    }

    override fun getItemCount(): Int = mValues.size

    inner class PostViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val username: TextView = mView.textView_username
        val likedBy: TextView = mView.textView_liked_by
        val postDescription: TextView = mView.textView_post_description


        }


    }

