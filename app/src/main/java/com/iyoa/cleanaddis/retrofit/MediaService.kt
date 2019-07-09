package com.iyoa.cleanaddis.retrofitEden

import com.iyoa.cleanaddis.data.common.MediaData
import com.iyoa.cleanaddis.data.common.MediaJSON
import com.iyoa.cleanaddis.data.common.MediaUUID
import com.iyoa.cleanaddis.entity.common.Media
import kotlinx.coroutines.Deferred
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface MediaService {
    @GET("/media")
    fun findMedia(): Call<List<Media>>

    @Multipart
    @POST("/media/createMedia")
    fun insertMedia(@Part("file") file: RequestBody, media: Media): Deferred<Response<MediaUUID>>

    @GET("/media/{id}")
    fun findMediaById(@Path("id") id:String): Call<Media>

    @GET("/media/{mediaUrl}")
    fun findMediaByPath(@Path("mediaUrl") mediaUrl:String ): Call<Media>


    @POST("/media")
    fun insertMedia(@Body media: MediaData): Deferred<Response<MediaJSON>>


    @PUT("/media/{id}")
    fun updateMedia(@Path("id") id:Long, @Body media: Media): Call<Void>

    @DELETE("/media/{id}")
    fun deleteMedia(@Path("id") id:Long): Call<Void>
}