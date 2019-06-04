package com.iyoa.cleanaddis.controller.posting

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.iyoa.cleanaddis.R
import com.iyoa.cleanaddis.adapters.posting.PostAdapters
import com.iyoa.cleanaddis.entity.posting.Post
import com.iyoa.cleanaddis.retrofitEden.PostService
import com.iyoa.cleanaddis.retrofitEden.PostServiceImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DisplayPostsRecyclerViewFragment : Fragment() {
    var listItems = emptyArray <String?>()
    private var listener: OnFragmentInteractionListener? = null
    lateinit var recyclerView: RecyclerView
    private var postServiceImpl:PostServiceImpl=PostServiceImpl()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        val view= inflater.inflate(R.layout.fragment_display_posts_recycler_view, container, false)
        val postService: PostService = PostServiceImpl().getPostServiceImpl()

        val call: Call<List<Post>> = postServiceImpl.findPosts()
        call.enqueue(object: Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.wtf("POST", t.message)
            }
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                listItems = arrayOfNulls<String>( response.body()!!.size)
                for (i in 0 until response.body()!!.size) {
                    val post = response.body()!![i]
                    listItems[i] = post.toString()
                }

            }
        })

        recyclerView = view.findViewById(R.id.recyclerView_front_post_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = context?.let { PostAdapters(it,listItems as List<Post>) }
        recyclerView.setHasFixedSize(true)
        return view
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
