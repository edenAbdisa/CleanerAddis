package com.iyoa.cleanaddis.retrofitDelilah

import com.iyoa.cleanaddis.utility.BASE_URL_NEW
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ReportServiceImpl {
    fun getAccountServiceImpl(): ReportService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL_NEW)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        return retrofit.create(ReportService::class.java)
    }
}