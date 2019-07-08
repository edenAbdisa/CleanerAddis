package com.iyoa.cleanaddis.retrofit

<<<<<<< HEAD:app/src/main/java/com/iyoa/cleanaddis/retrofit/ArticleServiceImpl.kt
import com.iyoa.cleanaddis.utility.BASE_URL_NEW
=======
import com.iyoa.cleanaddis.retrofitEden.FriendService
import com.iyoa.cleanaddis.utility.BASE_URL
>>>>>>> parent of 259b9a5... Article/News Feature: repository,retrofit endpoints modified:app/src/main/java/com/iyoa/cleanaddis/retrofitDelilah/ArticleServiceImpl.kt
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ArticleServiceImpl {

    fun getArticleServiceImpl(): ArticleService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        return retrofit.create(ArticleService::class.java)
    }
}