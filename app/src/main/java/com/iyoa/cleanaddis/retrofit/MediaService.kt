package com.iyoa.cleanaddis.retrofit

import com.iyoa.cleanaddis.data.common.MediaData
import com.iyoa.cleanaddis.entity.posting.Media
import retrofit2.Call
import retrofit2.http.*

interface MediaService {
    @GET("/media")
    fun findMedia(): Call<List<Media>>

    @GET("/media/{id}")
    fun findMediaById(@Path("id") id:Long): Call<Media>

    @GET("/media/{mediaUrl}")
    fun findMediaByPath(@Path("mediaUrl") mediaUrl:String ): Call<Media>

    @POST("/media")
    fun insertMedia(@Body media: MediaData): Call<Media>

    @PUT("/media/{id}")
    fun updateMedia(@Path("id") id:Long, @Body media: Media): Call<Void>

    @DELETE("/media/{id}")
    fun deleteMedia(@Path("id") id:Long): Call<Void>
}