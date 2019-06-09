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
import android.R
import androidx.databinding.DataBindingUtil
class PostAdapters (val context: Context) : RecyclerView.Adapter<PostAdapters.PostViewHolder>() {

    private var postList: List<Post> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
       /* val recyclerViewItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_post_display, parent, false)*/
        val binding = DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, R.layout.single_post_display, parent, false)

        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val item = postList[position]

        holder.SinglePostDisplayBinding..setPost(postList[position])
        holder.binding.thumbnail.setOnClickListener(View.OnClickListener {
            if (listener != null) {
                listener.onPostClicked(postList[position])
            }
        })
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

    public class PostViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
      public val SinglePostDisplayBinding singlePostDisplayBinding
        public fun ViewHolder(SinglePostDisplayBinding singlePostDisplayLayoutBinding){
            super(singlePostDisplayLayoutBinding)
            singlePostDisplayBinding= singlePostDisplayLayoutBinding

        }
       /* val username: TextView = mView.textView_username
        val likedBy: TextView = mView.textView_liked_by
        val postDescription: TextView = mView.textView_post_description*/


        }

    }

