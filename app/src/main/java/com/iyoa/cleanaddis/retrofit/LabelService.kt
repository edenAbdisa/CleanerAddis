package com.iyoa.cleanaddis.retrofitEden

import com.iyoa.cleanaddis.data.posting.LabelUUID
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface LabelService {
    @GET("/label/getByName/{name}")
    fun getLabelByName(@Path("name") labelName:String): Deferred<Response<LabelUUID>>

}