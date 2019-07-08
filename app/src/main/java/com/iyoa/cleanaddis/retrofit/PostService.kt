package com.iyoa.cleanaddis.retrofitEden

import com.iyoa.cleanaddis.data.posting.PostJSON
import com.iyoa.cleanaddis.data.posting.PostUUID
import com.iyoa.cleanaddis.entity.posting.Post
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface PostService {
    @GET("/post/getPosts")
    fun getPosts(): Deferred<Response<List<PostJSON>>>

    @PUT("/post/increaseLike/{id}")
    fun increaseNumberOfLikeOfPost(@Path("id") id:String):Deferred<Response<Post>>

    @GET("/post/{id}")
    fun findPostById(@Path("id") id:Long): Call<Post>

    @GET("/post")
    fun findByUsername(@Query("username") username:String ): Call<Post>

    @POST("/post")
    fun insertPost(@Body post:Post): Deferred<Response<Post>>

    @PUT("/post/{id}")
    fun updatePost(@Path("id") id:Long, @Body post:Post): Call<Void>



    @DELETE("/post/{id}")
    fun deletePost(@Path("id") id:Long): Call<Void>
}