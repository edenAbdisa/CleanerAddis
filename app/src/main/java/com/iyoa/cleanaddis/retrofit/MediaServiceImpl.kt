package com.iyoa.cleanaddis.retrofitEden

import com.iyoa.cleanaddis.data.common.MediaUUID
import com.iyoa.cleanaddis.entity.common.Media
import com.iyoa.cleanaddis.entity.posting.Comment
import com.iyoa.cleanaddis.utility.BASE_URL
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Multipart
import java.io.File

class MediaServiceImpl {

    fun getMediaService(): MediaService {

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        return retrofit.create(MediaService::class.java)
    }
    suspend fun insertMedia(file: Multipart, media: Media): Response<MediaUUID> =
        withContext(Dispatchers.IO) {
            getMediaService().insertMedia(file,media).await()
        }
}