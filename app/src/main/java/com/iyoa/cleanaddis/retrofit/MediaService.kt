package com.iyoa.cleanaddis.retrofitEden

import com.iyoa.cleanaddis.data.common.MediaUUID
import com.iyoa.cleanaddis.entity.common.Media
import com.iyoa.cleanaddis.entity.posting.Comment
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream

interface MediaService {
    @GET("/media")
    fun findMedia(): Call<List<Media>>

    @POST("/media/createMedia")
    @Multipart
    fun insertMedia( @Part("file") file: Multipart, @Body media: Media): Deferred<Response<MediaUUID>>

    @GET("/media/{id}")
    fun findMediaById(@Path("id") id:String): Call<Media>

    @GET("/media/{mediaUrl}")
    fun findMediaByPath(@Path("mediaUrl") mediaUrl:String ): Call<Media>

    @POST("/media")
    fun insertMedia(@Body media: Media): Deferred<Response<Media>>

    @PUT("/media/{id}")
    fun updateMedia(@Path("id") id:Long, @Body media: Media): Call<Void>

    @DELETE("/media/{id}")
    fun deleteMedia(@Path("id") id:Long): Call<Void>
}