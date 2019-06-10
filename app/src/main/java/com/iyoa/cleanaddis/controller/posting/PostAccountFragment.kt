package com.iyoa.cleanaddis.controller.posting

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iyoa.cleanaddis.R
import com.iyoa.cleanaddis.entity.user.User
import com.iyoa.cleanaddis.retrofit.PostService
import com.iyoa.cleanaddis.retrofit.PostServiceImpl
import com.iyoa.cleanaddis.retrofit.UserServiceImpl
import com.iyoa.cleanaddis.utility.Connection
import kotlinx.android.synthetic.main.fragment_post_account.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostAccountFragment : Fragment() {
    private var userServiceImpl: UserServiceImpl =
        UserServiceImpl()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_post_account, container, false)
        if (Connection.checkConnection(context)) {
            val postService: PostService = PostServiceImpl().getPostServiceImpl()

            val call: Call<User> = userServiceImpl.findUser("edenA")
            call.enqueue(object : Callback<User> {
                override fun onFailure(call: Call<User>, t: Throwable) {
                    Log.wtf("POST", t.message)
                }

                override fun onResponse(call: Call<User>, response: Response<User>) {
                    val userAccount = response.body()
                    view.textView_username.text = userAccount?.username

                }
            })
        }


        return view
    }
}
