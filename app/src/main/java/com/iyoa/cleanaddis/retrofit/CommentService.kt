package com.iyoa.cleanaddis.retrofit
import com.iyoa.cleanaddis.entity.posting.Comment
import retrofit2.Call
import retrofit2.http.*

interface CommentService {
    @GET("/comment/getComments")
    fun findComments(): Call<List<Comment>>

    @GET("/comment/{id}")
    fun findCommentById(@Path("id") id:Long): Call<Comment>

    @GET("/comment")
    fun findByUsername(@Query("username") username:String ): Call<Comment>

    @POST("/comment")
    fun insertComment(@Body comment:Comment): Call<Void>

    @PUT("/comment/{id}")
    fun updateComment(@Path("id") id:Long, @Body comment:Comment): Call<Void>

    @DELETE("/comment/{id}")
    fun deleteComment(@Path("id") id:Long): Call<Void>
}