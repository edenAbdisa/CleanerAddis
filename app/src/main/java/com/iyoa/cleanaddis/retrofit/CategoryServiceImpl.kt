package com.iyoa.cleanaddis.retrofitEden

import com.iyoa.cleanaddis.data.common.Category
import com.iyoa.cleanaddis.utility.BASE_URL
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class CategoryServiceImpl {
    fun CategoryService(): CategoryService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        return retrofit.create(CategoryService::class.java)
    }

    suspend fun getCategoryByName(categoryName:String): Response<Category> =
        withContext(Dispatchers.IO){
            CategoryService().getCategoryByName(categoryName).await()
        }
}