package com.iyoa.cleanaddis.adapters.posting

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.*
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.iyoa.cleanaddis.entity.posting.Post
import com.iyoa.cleanaddis.R
import com.iyoa.cleanaddis.adapters.commenting.CommentAdapter
import com.iyoa.cleanaddis.viewModels.posting.CommentViewModel
import com.iyoa.cleanaddis.databinding.SinglePostDisplayBinding
import java.util.*

class PostAdapters (val context: Context,val commentViewModel:CommentViewModel) : ListAdapter<Post,PostAdapters.PostViewHolder>(PostDiffCallBack()) {

    private var postList: List<Post> = emptyList()
    private  lateinit var binding:ViewDataBinding
    lateinit var view:SinglePostDisplayBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {

        view =   DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.single_post_display, parent, false
            )


        return PostViewHolder(view)

    }
     fun callComment( uuid: String){

        val commentListAdapter = CommentAdapter(context)
        var commentList = commentListAdapter.getComments()

        val recyclerViewComment=view.root.findViewById<RecyclerView>(R.id.recyclerView_comment_list)
        val layoutManager = LinearLayoutManager(context)
         recyclerViewComment.adapter = context?.let { CommentAdapter(it) }
         recyclerViewComment.setHasFixedSize(true)
    }
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {

        getItem(position).let { post ->
            with(holder) {

                bind(post)
            }
        }
    }

    internal fun getPosts(): List<Post> {
        return postList
    }

    internal fun setPosts(postList: List<Post>) {
        this.postList = postList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = postList.size

    open inner class PostViewHolder(private val binding: SinglePostDisplayBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind( item: Post) {
            with(binding) {
                binding.textViewUsername.text = item.username
                executePendingBindings()
            }
            callComment(item.uuid)
        }
    }
}
class PostDiffCallBack: DiffUtil.ItemCallback<Post>(){
    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.uuid == newItem.uuid
    }

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem == newItem
    }

}