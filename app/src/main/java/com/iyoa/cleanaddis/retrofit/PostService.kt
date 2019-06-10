package com.iyoa.cleanaddis.retrofit

import com.iyoa.cleanaddis.entity.posting.Post
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface PostService {
    @GET("/post/getPosts")
    fun findPosts(): Call<List<Post>>

    @GET("/post/{id}")
    fun findPostById(@Path("id") id:Long): Call<Post>

    @GET("/post")
    fun findByUsername(@Query("username") username:String ): Call<Post>

    @POST("/post")
    fun insertPost(@Body post:Post): Call<Void>

    @PUT("/post/{id}")
    fun updatePost(@Path("id") id:Long, @Body post:Post): Call<Void>

    @DELETE("/post/{id}")
    fun deletePost(@Path("id") id:Long): Call<Void>
}