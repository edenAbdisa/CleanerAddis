package com.iyoa.cleanaddis.retrofit

import com.iyoa.cleanaddis.entity.posting.Friend
import com.iyoa.cleanaddis.entity.posting.Post
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface FriendService {
    @GET("/friend")
    fun findFriends(): Call<List<Friend>>

    @GET("/friend/{id}")
    fun findFriendsById(@Path("id") id:Long): Call<Friend>

    @GET("/friend")
    fun findFriendByUsername(@Query("username") username:String ): Call<Friend>

    @POST("/friend")
    fun insertFriend(@Body friend: Friend): Call<Void>

    @PUT("/friend/{id}")
    fun updateFriend(@Path("id") id:Long, @Body friend: Friend): Call<Void>

    @DELETE("/friend/{id}")
    fun deleteFriend(@Path("id") id:Long): Call<Void>
}