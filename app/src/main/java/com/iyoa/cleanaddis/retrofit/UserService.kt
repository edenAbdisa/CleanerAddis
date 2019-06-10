package com.iyoa.cleanaddis.retrofit

import com.iyoa.cleanaddis.entity.posting.Post
import com.iyoa.cleanaddis.entity.user.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UserService {
    @GET("/getUser/{username}")
    fun findByUsername(@Path("username") username:String ): Call<User>

}