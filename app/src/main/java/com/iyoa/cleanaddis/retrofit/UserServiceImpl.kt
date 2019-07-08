package com.iyoa.cleanaddis.retrofitEden

import com.iyoa.cleanaddis.entity.user.User
import com.iyoa.cleanaddis.utility.BASE_URL
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import com.squareup.moshi.*
import java.util.*


class UserServiceImpl {

    fun getUserService(): UserService {


        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        return retrofit.create(UserService::class.java)
    }

    suspend fun getUserByName(username:String): Response<User> =
        withContext(Dispatchers.IO){
            getUserService().findUserByUsername(username).await()
        }
}