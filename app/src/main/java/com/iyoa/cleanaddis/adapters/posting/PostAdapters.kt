package com.iyoa.cleanaddis.adapters.posting

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.*
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.iyoa.cleanaddis.entity.posting.Post
import com.iyoa.cleanaddis.R
import com.iyoa.cleanaddis.adapters.commenting.CommentAdapter
import com.iyoa.cleanaddis.controller.posting.DisplayPostsRecyclerViewFragment
import com.iyoa.cleanaddis.data.common.MediaUUID
import com.iyoa.cleanaddis.data.posting.CommentUUID
import com.iyoa.cleanaddis.data.posting.PostUUID
import com.iyoa.cleanaddis.viewModels.posting.CommentViewModel
import com.iyoa.cleanaddis.databinding.SinglePostDisplayBinding
import com.iyoa.cleanaddis.entity.posting.Comment
import com.iyoa.cleanaddis.utility.CommentListConvertor
import com.iyoa.cleanaddis.utility.DateUtility
import com.iyoa.cleanaddis.viewModels.posting.PostViewModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.Moshi
import java.util.*

class PostAdapters (val context: Context,val postViewModel: PostViewModel,val commentViewModel: CommentViewModel) : ListAdapter<PostUUID,PostAdapters.PostViewHolder>(PostDiffCallBack()) {

    private var postList: List<PostUUID> = emptyList()
    private  lateinit var binding:SinglePostDisplayBinding

    lateinit var view:SinglePostDisplayBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = SinglePostDisplayBinding.inflate(inflater, parent, false)
        val viewHolder = PostViewHolder( binding)
        // binding.setLifecycleOwner(viewHolder)
        //view =SinglePostDisplayBinding.inflate(LayoutInflater.from(parent.context),R.layout.single_post_display, parent, false)
        return viewHolder

    }
    fun callComment(comments: List<CommentUUID>?){
        //  var dis= DisplayPostsRecyclerViewFragment()
        val listComments=comments

        val commentListAdapter = CommentAdapter(context,commentViewModel)
        commentListAdapter.setComments(listComments)

        val recyclerViewComment=view.root.findViewById<RecyclerView>(R.id.recyclerView_comment_list)

        recyclerViewComment.layoutManager = LinearLayoutManager(context)
        recyclerViewComment.adapter = context.let { commentListAdapter }
        recyclerViewComment.setHasFixedSize(true)
    }
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        postList.get(position).let { post ->
            with(holder) {
                val moshi: Moshi = Moshi.Builder().build()
                val adapter: JsonAdapter<MediaUUID> = moshi.adapter(MediaUUID::class.java)
                val mediaParsed = adapter.fromJson( post.mediaUuid)
                Toast.makeText(context,mediaParsed!!.url,Toast.LENGTH_LONG).show()
                post.mediaUuid=mediaParsed!!.url
                postViewModel.post.set(post)
                binding.viewmodel= postViewModel
                bind(post)
            }
        }
    }
    internal fun getPosts(): List<PostUUID> {
        return postList
    }

    internal fun setPosts(postList: List<PostUUID>) {
        this.postList = postList
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int = postList.size

    open inner class PostViewHolder(private val binding: SinglePostDisplayBinding ) : RecyclerView.ViewHolder(binding.root) {
        fun bind( item: PostUUID) {
            with(binding) {

                executePendingBindings()
            }
            val conv= CommentListConvertor()
            //callComment(conv.toCommentUUIDList(item.listComment))
        }
    }
}

class PostDiffCallBack: DiffUtil.ItemCallback<PostUUID>(){
    override fun areItemsTheSame(oldItem: PostUUID, newItem: PostUUID): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: PostUUID, newItem: PostUUID): Boolean {
        return oldItem == newItem
    }

}