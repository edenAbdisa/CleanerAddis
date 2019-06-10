package com.iyoa.cleanaddis.adapters.commenting

import android.content.Context
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
import com.iyoa.cleanaddis.databinding.SingleCommentDisplayBinding
import com.iyoa.cleanaddis.viewModels.posting.CommentViewModel

class CommentAdapter (val context: Context) : ListAdapter<Comment,CommentAdapter.CommentViewHolder>(CommentDiffCallBack()) {

    private var commentList: List<Comment> = emptyList()
    private  lateinit var binding:ViewDataBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        return CommentViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.single_comment_display, parent, false
            )
        )

    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {

        getItem(position).let { comment ->
            with(holder) {

                bind(comment)
            }
        }
    }

    internal fun getComments(): List<Comment> {
        return commentList
    }

    internal fun setComments(commentList: List<Comment>) {
        this.commentList = commentList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = commentList.size

    open inner class CommentViewHolder(private val binding: SingleCommentDisplayBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind( item: Comment) {
            with(binding) {
                comment=item
                executePendingBindings()
            }
        }
    }
}
class CommentDiffCallBack: DiffUtil.ItemCallback<Comment>(){
    override fun areItemsTheSame(oldItem: Comment, newItem: Comment): Boolean {
        return oldItem.uuid == newItem.uuid
    }

    override fun areContentsTheSame(oldItem: Comment, newItem: Comment): Boolean {
        return oldItem == newItem
    }

}