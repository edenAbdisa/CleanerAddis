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

    private var postList: List<Post> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val recyclerViewItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_post_display, parent, false)
        recyclerViewItem.setOnClickListener{}
        return PostViewHolder(recyclerViewItem)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val item = postList[position]
        //add a listener that will allow to delete the post
        //to item after checking if the currently logged user is equal to item.username
        holder.username.text = item.username
        holder.likedBy.text = item.noLike.toString()
        holder.postDescription.text=item.mediaUuid.toString()


    }
    internal fun getPosts():List<Post>{
        return postList
    }
    internal fun setPosts(postList:List<Post>){
        this.postList = postList
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int = postList.size

    inner class PostViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val username: TextView = mView.textView_username
        val likedBy: TextView = mView.textView_liked_by
        val postDescription: TextView = mView.textView_post_description


        }


    }

