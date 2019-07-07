package com.iyoa.cleanaddis.retrofitEden

import com.iyoa.cleanaddis.data.posting.CommentUUID
import com.iyoa.cleanaddis.entity.posting.Comment
import com.iyoa.cleanaddis.utility.BASE_URL
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


 class CommentServiceImpl {
    fun getCommentService(): CommentService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        return retrofit.create(CommentService::class.java)
    }
     suspend fun insertComment(comment: Comment): Response<Comment> =
         withContext(Dispatchers.IO) {
             getCommentService().insertComment(comment).await()
         }
     suspend fun getCommentByPostId(postId: String): Response<List<CommentUUID>> =
         withContext(Dispatchers.IO){
             getCommentService().getAllCommentOfPost(postId).await()
         }
}