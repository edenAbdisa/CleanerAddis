package com.iyoa.cleanaddis.retrofit

import com.iyoa.cleanaddis.entity.posting.Comment
import com.iyoa.cleanaddis.utility.BASE_URL
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


 class CommentServiceImpl {
    fun getCommentServiceImpl(): CommentService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        return retrofit.create(CommentService::class.java)
    }

     fun findComments(): Call<List<Comment>> {
        return getCommentServiceImpl().findComments()
     }
}