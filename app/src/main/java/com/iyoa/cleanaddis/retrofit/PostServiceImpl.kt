package com.iyoa.cleanaddis.retrofitEden

import com.iyoa.cleanaddis.data.posting.PostUUID
import com.iyoa.cleanaddis.entity.posting.Comment
import com.iyoa.cleanaddis.entity.posting.Post
import com.iyoa.cleanaddis.utility.BASE_URL
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


 class PostServiceImpl {
    fun getPostService(): PostService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        return retrofit.create(PostService::class.java)
    }
     suspend fun insertPost(post: Post): Response<Post> =
         withContext(Dispatchers.IO) {
             getPostService().insertPost(post).await()
         }
     suspend fun increaseNumberOfLikeOfPost(postId: String): Response<Post> =
         withContext(Dispatchers.IO) {
             getPostService().increaseNumberOfLikeOfPost(postId).await()
         }
     suspend fun getPosts(): Response<List<PostUUID>> =
         withContext(Dispatchers.IO){
             getPostService().getPosts().await()
         }
}