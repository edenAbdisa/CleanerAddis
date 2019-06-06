package com.iyoa.cleanaddis.retrofitEden

import com.iyoa.cleanaddis.entity.posting.Post
import com.iyoa.cleanaddis.entity.user.User
import com.iyoa.cleanaddis.utility.BASE_URL
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class UserServiceImpl {

    fun getUserServiceImpl(): UserService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        return retrofit.create(UserService::class.java)
    }

    fun findUser(username:String): Call<User> {
        return getUserServiceImpl().findByUsername(username)
    }
}