package com.iyoa.cleanaddis.retrofitAbigya

import com.iyoa.cleanaddis.data.common.Category

import com.iyoa.cleanaddis.entity.posting.Friend
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TeachingCategoryService {

    @GET("category/categories")
    fun findCategories(): Call<List<Category>>

    @GET("/category/{id}")
    fun findCategoryById(@Path("id") id:String): Call<Category>



}