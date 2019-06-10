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
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.iyoa.cleanaddis.MainActivity
import com.iyoa.cleanaddis.R
import com.iyoa.cleanaddis.adapters.posting.PostAdapters
import com.iyoa.cleanaddis.entity.posting.Post
import com.iyoa.cleanaddis.retrofit.PostService
import com.iyoa.cleanaddis.retrofit.PostServiceImpl
import com.iyoa.cleanaddis.utility.Connection.Companion.checkConnection
import com.iyoa.cleanaddis.viewModels.posting.PostViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DisplayPostsRecyclerViewFragment : Fragment() {
     lateinit var postViewModel: PostViewModel
    val context = MainActivity()
    var listItems :List <Post>? = emptyList()
    private var listener: OnFragmentInteractionListener? = null
    lateinit var recyclerView: RecyclerView
    private lateinit var postService: PostService


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        val view= inflater.inflate(R.layout.fragment_display_posts_recycler_view, container, false)

        val postListAdapter = PostAdapters(context)
        var postList = postListAdapter.getPosts()
        loadPosts(postListAdapter,postList)
        recyclerView = view.findViewById(R.id.recyclerView_front_post_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = context?.let { PostAdapters(it) }
        recyclerView.setHasFixedSize(true)
        return view
    }
    fun loadPosts(postAdapter:PostAdapters,  postList:List<Post>){
        var postList = postList
        postService = PostServiceImpl().getPostServiceImpl()
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

    companion object {
    }
}
