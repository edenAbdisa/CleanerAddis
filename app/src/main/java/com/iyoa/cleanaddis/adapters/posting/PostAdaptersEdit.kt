package com.iyoa.cleanaddis.adapters.posting

import android.content.Context
import android.util.Log
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
import com.iyoa.cleanaddis.data.posting.CommentJSON
import com.iyoa.cleanaddis.data.posting.CommentUUID
import com.iyoa.cleanaddis.data.posting.PostJSON
import com.iyoa.cleanaddis.data.posting.PostUUID
import com.iyoa.cleanaddis.databinding.SingleEditablePostBinding
import com.iyoa.cleanaddis.viewModels.posting.CommentViewModel
import com.iyoa.cleanaddis.databinding.SinglePostDisplayBinding
import com.iyoa.cleanaddis.entity.posting.Comment
import com.iyoa.cleanaddis.utility.CommentListConvertor
import com.iyoa.cleanaddis.utility.DateUtility
import com.iyoa.cleanaddis.viewModels.posting.PostViewModel
import com.squareup.moshi.*
import com.squareup.picasso.Picasso
import java.util.*

class PostAdaptersEdit (val context: Context,val postViewModel: PostViewModel,val commentViewModel: CommentViewModel) : ListAdapter<PostUUID,PostAdaptersEdit.PostViewHolder>(PostDiffCallBackEdit()) {

    private var postList: List<PostJSON> = emptyList()
    private  lateinit var binding:SingleEditablePostBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = SingleEditablePostBinding.inflate(inflater, parent, false)
        val viewHolder = PostViewHolder( binding)
        return viewHolder

    }
    fun callComment(comments: List<CommentJSON>?){
        //  var dis= DisplayPostsRecyclerViewFragment()
        val listComments=comments

      /* val commentListAdapter = CommentAdapter(context,commentViewModel)
        commentListAdapter.setComments(listComments)

        val recyclerViewComment=binding.recyclerViewCommentList

        recyclerViewComment.layoutManager = LinearLayoutManager(context)
        recyclerViewComment.adapter = context.let { commentListAdapter }
        recyclerViewComment.setHasFixedSize(true)*/
    }
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        postList.get(position).let { post ->
            with(holder) {
                val moshi: Moshi = Moshi.Builder().build()
                val adapter: JsonAdapter<MediaUUID> = moshi.adapter(MediaUUID::class.java)
                Log.println(5,"post",post.toString())
                postViewModel.post.set(post)
                binding.viewmodel= postViewModel
                bind(post)
            }
        }
    }
    internal fun getPosts(): List<PostJSON> {
        return postList
    }

    internal fun setPosts(postList: List<PostJSON>) {
        this.postList = postList
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int = postList.size

    open inner class PostViewHolder(private val binding: SingleEditablePostBinding ) : RecyclerView.ViewHolder(binding.root) {
        fun bind( item: PostJSON) {
          // Picasso.with(context).load(item.media.url).into(binding.imageViewPostedImage);

            with(binding) {

                executePendingBindings()
            }
           /* val moshi=Moshi.Builder().build()
            val listType = Types.newParameterizedType(List::class.java, CommentJSON::class.java)
            val adapter: JsonAdapter<List<CommentJSON>> = moshi.adapter(listType)
            val result = adapter.fromJson(item.comments.toString())*/
            //callComment(item.comments)
        }
    }
}

class PostDiffCallBackEdit: DiffUtil.ItemCallback<PostUUID>(){
    override fun areItemsTheSame(oldItem: PostUUID, newItem: PostUUID): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: PostUUID, newItem: PostUUID): Boolean {
        return oldItem == newItem
    }

}