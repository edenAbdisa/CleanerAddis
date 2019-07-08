package com.iyoa.cleanaddis.controller.posting

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.iyoa.cleanaddis.MainActivity
import com.iyoa.cleanaddis.R
import com.iyoa.cleanaddis.adapters.posting.PostAdapters
import com.iyoa.cleanaddis.data.posting.CommentUUID
import com.iyoa.cleanaddis.data.posting.PostUUID
import com.iyoa.cleanaddis.entity.posting.Comment
import com.iyoa.cleanaddis.entity.posting.Post
import com.iyoa.cleanaddis.retrofitEden.PostService
import com.iyoa.cleanaddis.retrofitEden.PostServiceImpl
import com.iyoa.cleanaddis.utility.Connection.Companion.checkConnection
import com.iyoa.cleanaddis.viewModels.posting.CommentViewModel
import com.iyoa.cleanaddis.viewModels.posting.PostViewModel
import kotlinx.android.synthetic.main.fragment_display_posts_recycler_view.view.*
import kotlinx.android.synthetic.main.fragment_display_posts_recycler_view.view.navigation_bottom_bar
import kotlinx.android.synthetic.main.fragment_post_account.view.*
import kotlinx.android.synthetic.main.single_post_display.*
import kotlinx.android.synthetic.main.single_post_display.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DisplayPostsRecyclerViewFragment : NavHostFragment() {
    lateinit var postViewModel: PostViewModel

    lateinit var commentViewModel: CommentViewModel
    //lateinit var userViewModel: UserViewModel

    val context = MainActivity()
    private var listener: OnFragmentInteractionListener? = null
    private lateinit var postService: PostService


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        postViewModel = ViewModelProviders.of(this).get(PostViewModel::class.java)
        commentViewModel = ViewModelProviders.of(this).get(CommentViewModel::class.java)
        val binding = inflater.inflate(R.layout.fragment_display_posts_recycler_view, container, false)
        val navController = this.findNavController()
        binding.navigation_bottom_bar?.let {
            NavigationUI.setupWithNavController(it, navController)}
        val postListAdapter = PostAdapters(context,postViewModel,commentViewModel)
        loadPosts(postListAdapter)

        binding.recyclerView_front_post_view.layoutManager = LinearLayoutManager(context)
        binding.recyclerView_front_post_view.adapter = context.let { postListAdapter }

        return binding
    }

    fun loadPosts(postAdapter: PostAdapters) {
        postViewModel.getPosts()
        postViewModel.getResponses.observe(this, Observer { response ->
            response.body()?.run{
                postAdapter.setPosts(this)
            }
        })
    }


    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onDetach() {
        super.onDetach()
        commentViewModel = ViewModelProviders.of(this).get(CommentViewModel::class.java)
        listener = null
    }

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(uri: Uri)
    }
}
