package com.iyoa.cleanaddis.retrofitEden

import com.iyoa.cleanaddis.data.posting.LabelUUID
import com.iyoa.cleanaddis.utility.BASE_URL
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class LabelServiceImpl {
    fun labelService(): LabelService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        return retrofit.create(LabelService::class.java)
    }

    suspend fun getLabelByName(labelName:String): Response<LabelUUID> =
        withContext(Dispatchers.IO){
            labelService().getLabelByName(labelName).await()
        }
}