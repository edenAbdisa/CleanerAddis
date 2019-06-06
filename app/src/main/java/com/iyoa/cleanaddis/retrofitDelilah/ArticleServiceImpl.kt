package com.iyoa.cleanaddis.retrofitDelilah

import com.iyoa.cleanaddis.retrofitEden.FriendService
import com.iyoa.cleanaddis.utility.BASE_URL
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