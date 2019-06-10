package com.iyoa.cleanaddis.adapters.posting

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.*
import androidx.recyclerview.widget.RecyclerView
import com.iyoa.cleanaddis.entity.posting.Post
import com.iyoa.cleanaddis.R
import com.iyoa.cleanaddis.viewModels.posting.PostViewModel

class PostAdapters (val context: Context) : RecyclerView.Adapter<PostAdapters.PostViewHolder>() {

    private var postList: List<Post> = emptyList()
    lateinit var viewModel:PostViewModel
    private  lateinit var binding:ViewDataBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        viewModel = ViewModelProviders.of(this).get(
            PostViewModel::class.java
        )
         binding =
            DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, R.layout.single_post_display, parent, false)
        val viewHolder = BindingViewHolder(binding.root, binding)

        binding.setLifecycleOwner(viewHolder)
        return viewHolder
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        var item = postList[position]
        val context = holder.containerView.context

        when (item) {
            is Post -> {
                if (holder is BindingViewHolder) {
                    holder.apply {
                        viewModel.liveItem.post.value = item
                        binding.viewModel = viewModel

                        // optional observer to update name if it changes (2-way binding through EditText)
                        viewModel.liveItem.post.observe(this, Observer {
                            it?.also {
                                item = it
                            }
                        })
                    }
                }
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

    open inner class PostViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView)

    inner class BindingViewHolder(
        override val containerView: View,
        val binding: com.iyoa.cleanaddis.databinding.SinglePostDisplayBinding
    ) : PostViewHolder(containerView),
        LifecycleOwner {
        private val lifecycleRegistry = LifecycleRegistry(this)

        init {
            lifecycleRegistry.markState(Lifecycle.State.INITIALIZED)
        }

        override fun getLifecycle(): Lifecycle {
            return lifecycleRegistry
        }
    }

}