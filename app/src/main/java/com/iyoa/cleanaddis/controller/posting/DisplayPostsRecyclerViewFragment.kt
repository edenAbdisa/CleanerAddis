package com.iyoa.cleanaddis.controller.posting

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.iyoa.cleanaddis.MainActivity
import com.iyoa.cleanaddis.R
import com.iyoa.cleanaddis.adapters.posting.PostAdapters
import com.iyoa.cleanaddis.entity.posting.Post
import com.iyoa.cleanaddis.retrofitEden.PostService
import com.iyoa.cleanaddis.retrofitEden.PostServiceImpl
import com.iyoa.cleanaddis.databinding.SinglePostDisplayBinding
import com.iyoa.cleanaddis.utility.Connection.Companion.checkConnection
import com.iyoa.cleanaddis.viewModels.posting.CommentViewModel
import com.iyoa.cleanaddis.viewModels.posting.PostViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DisplayPostsRecyclerViewFragment : Fragment() {
    lateinit var postViewModel: PostViewModel

    lateinit var commentViewModel: CommentViewModel
    //lateinit var userViewModel: UserViewModel

    val context = MainActivity()
    private var listener: OnFragmentInteractionListener? = null
    private lateinit var postService:PostService


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        postViewModel = ViewModelProviders.of(this).get(PostViewModel::class.java)
        commentViewModel = ViewModelProviders.of(this).get(CommentViewModel::class.java)
        val binding = SinglePostDisplayBinding.inflate(R.layout.fragment_display_posts_recycler_view, container, false)

        val postListAdapter = PostAdapters(context,commentViewModel)
        var postList = postListAdapter.getPosts()

        loadPosts(postListAdapter,postList)

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = context?.let { PostAdapters(it) }
        binding.recyclerView.setHasFixedSize(true)
        return view
    }
    fun loadPosts(postAdapter:PostAdapters,  postList:List<Post>){
        var postList = postList
        postService =PostServiceImpl().getPostServiceImpl()
        val call: Call<List<Post>> = postService.findPosts()
        call.enqueue(object:Callback<List<Post>>{
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {

                postList = response.body() as List<Post>
                postAdapter.setPosts(postList)
                addToViewModel(postList)
                Log.println(Log.INFO, "PostLine78", postList?.get(0).toString())
            }

            override fun onFailure(call:Call<List<Post>>,t:Throwable){
                Log.wtf("PostLine82",t.message)
            }

        })
    }
    fun addToViewModel(posts:List<Post>){
        postViewModel = ViewModelProviders.of(this).get(
            PostViewModel::class.java
        )
        if(checkConnection(view?.context)){
            postViewModel.allPost.observe(this,androidx.lifecycle.Observer {
                    posts->posts?.let{PostAdapters(context).setPosts(posts)}
            })
            run{postViewModel.addPosts(posts)}
        }
        else{
            Toast.makeText(context,"Check your network connection",Toast.LENGTH_SHORT)
        }

    }

    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        /*if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }*/
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(uri: Uri)
    }
}
