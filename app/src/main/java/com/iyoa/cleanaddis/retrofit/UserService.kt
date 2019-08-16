package com.iyoa.cleanaddis.retrofitEden

import com.iyoa.cleanaddis.entity.user.User
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {
    @GET("/user/get/{username}")
    fun findUserByUsername(@Path("username") username:String ): Deferred<Response<User>>

}