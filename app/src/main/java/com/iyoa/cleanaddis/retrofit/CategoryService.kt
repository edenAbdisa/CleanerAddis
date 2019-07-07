package com.iyoa.cleanaddis.retrofitEden

import com.iyoa.cleanaddis.data.common.Category
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CategoryService {
    @GET("/category/{name}")
    fun getCategoryByName(@Path("name") categoryName:String): Deferred<Response<Category>>

}