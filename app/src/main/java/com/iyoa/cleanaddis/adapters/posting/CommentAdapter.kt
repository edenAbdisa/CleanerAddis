package com.iyoa.cleanaddis.adapters.commenting

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.*
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.iyoa.cleanaddis.entity.posting.Comment
import com.iyoa.cleanaddis.R
import com.iyoa.cleanaddis.data.posting.CommentUUID
import com.iyoa.cleanaddis.databinding.SingleCommentDisplayBinding
import com.iyoa.cleanaddis.retrofitEden.CommentServiceImpl
import com.iyoa.cleanaddis.utility.Connection
import com.iyoa.cleanaddis.viewModels.posting.CommentViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentAdapter (val context: Context,val commentViewModel: CommentViewModel) : ListAdapter<CommentUUID,CommentAdapter.CommentViewHolder>(CommentDiffCallBack()) {

    private var comments: List<CommentUUID>? = emptyList()
    private  lateinit var binding:SingleCommentDisplayBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = SingleCommentDisplayBinding.inflate(inflater, parent, false)
        val viewHolder = CommentViewHolder( binding)

        return viewHolder
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        comments!!.get(position).let { comment ->
            with(holder) {
                commentViewModel.comment.set(comment)
                binding.viewmodel= commentViewModel
                bind(comment)
            }
        }
    }
    internal fun getComments(): List<CommentUUID>? {
        return comments
    }

    internal fun setComments(commentList: List<CommentUUID>?) {
        this.comments = commentList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = comments!!.size

    open inner class CommentViewHolder(private val binding: SingleCommentDisplayBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind( item: CommentUUID) {
            with(binding) {
                executePendingBindings()
            }
        }
    }
}
class CommentDiffCallBack: DiffUtil.ItemCallback<CommentUUID>(){
    override fun areItemsTheSame(oldItem: CommentUUID, newItem: CommentUUID): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: CommentUUID, newItem: CommentUUID): Boolean {
        return oldItem == newItem
    }

}