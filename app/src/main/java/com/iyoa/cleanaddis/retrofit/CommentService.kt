package com.iyoa.cleanaddis.retrofitEden

import androidx.lifecycle.LiveData
import com.iyoa.cleanaddis.data.posting.CommentUUID
import com.iyoa.cleanaddis.entity.posting.Comment
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface CommentService {
    @GET("/comment/getComments")
    fun findComments(): Call<List<Comment>>

    @GET("/comment/getCommentsOfThispost/{postId}")
    fun getAllCommentOfPost(@Path("postId") postUuid:String): Deferred<Response<List<CommentUUID>>>

    @GET("/comment/{id}")
    fun findCommentById(@Path("id") id:String): Call<Comment>

    @GET("/comment")
    fun findByUsername(@Query("username") username:String ): Call<Comment>

    @POST("/comment/add")
    fun insertComment(@Body comment:Comment): Deferred<Response<Comment>>

    @PUT("/comment/{id}")
    fun updateComment(@Path("id") id:Long, @Body comment:Comment): Call<Void>

    @DELETE("/comment/{id}")
    fun deleteComment(@Path("id") id:Long): Call<Void>
}