package com.iyoa.cleanaddis.controller.posting

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.iyoa.cleanaddis.MainActivity
import com.iyoa.cleanaddis.R
import com.iyoa.cleanaddis.adapters.posting.PostAdapters
import com.iyoa.cleanaddis.entity.posting.Post
import com.iyoa.cleanaddis.entity.user.User
import com.iyoa.cleanaddis.retrofitEden.PostService
import com.iyoa.cleanaddis.retrofitEden.PostServiceImpl
import com.iyoa.cleanaddis.retrofitEden.UserServiceImpl
import com.iyoa.cleanaddis.utility.Connection
import com.iyoa.cleanaddis.viewModels.common.UserViewModel
import com.iyoa.cleanaddis.viewModels.posting.CommentViewModel
import com.iyoa.cleanaddis.viewModels.posting.PostViewModel
import kotlinx.android.synthetic.main.fragment_display_posts_recycler_view.view.*
import kotlinx.android.synthetic.main.fragment_post.view.*
import kotlinx.android.synthetic.main.fragment_post_account.view.*
import kotlinx.android.synthetic.main.fragment_post_account.view.navigation_bottom_bar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostAccountFragment : Fragment() {
    private var userServiceImpl: UserServiceImpl =UserServiceImpl()
    lateinit var postViewModel: PostViewModel
    lateinit var userViewModel: UserViewModel
    lateinit var commentViewModel: CommentViewModel
    val context = MainActivity()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_post_account, container, false)
        val navController = this.findNavController()
        view.navigation_bottom_bar?.let {
            NavigationUI.setupWithNavController(it, navController)}
        postViewModel = ViewModelProviders.of(this).get(PostViewModel::class.java)
        userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        commentViewModel = ViewModelProviders.of(this).get(CommentViewModel::class.java)

        val postListAdapter = PostAdapters(context,postViewModel,commentViewModel)
        // loadPosts(postListAdapter)
        displayUserInfo()
        view.recyclerview_user_posts.layoutManager = LinearLayoutManager(context)
        view.recyclerview_user_posts.adapter = context.let { postListAdapter }
        return view
    }
    fun loadPosts(postAdapter: PostAdapters) {
        postViewModel.getPosts()
        postViewModel.getResponses.observe(this, Observer { response ->
            response.body()?.run{
                postAdapter.setPosts(this)
            }
        })
    }
    fun displayUserInfo(){
        val sharedPreference =
            activity?.getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE)
        var username: String = sharedPreference!!.getString("username", "edenA")
        userViewModel.getUserByName(username)
        userViewModel.getResponse.observe(this, Observer { response ->
            response.body()?.run{
                Toast.makeText(context,"line 79"+this.username,Toast.LENGTH_LONG).show()
                Toast.makeText(context,this.toString(),Toast.LENGTH_LONG).show()
                userViewModel.user.set(this)
            }
        })

    }
}
