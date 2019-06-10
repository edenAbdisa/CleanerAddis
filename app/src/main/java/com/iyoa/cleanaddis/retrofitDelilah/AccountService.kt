package com.iyoa.cleanaddis.retrofitDelilah

import com.iyoa.cleanaddis.data.news.Article
import com.iyoa.cleanaddis.data.user.User
import com.iyoa.cleanaddis.data.user.UserData
import com.iyoa.cleanaddis.entity.posting.Friend
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AccountService {

    @GET("user/addUser")
    fun addUser(user: UserData): Call<User>

    @GET("/getUser/{username}")
    fun getUserByUsername(@Path("username") username:String): Call<User>


}