package com.iyoa.cleanaddis.retrofit

import com.iyoa.cleanaddis.data.news.Article
import com.iyoa.cleanaddis.entity.posting.Friend
import retrofit2.Call
import retrofit2.http.*

interface ArticleService {
    @GET("article/articles")
    fun findArticles(): Call<List<Article>>

    @GET("/article/{id}")
    fun findArticleById(@Path("id") id:String): Call<Friend>

    @GET("/recent-articles")
    fun findArticleByPublishedDate(@Query("date") username:String ): Call<Friend>


}