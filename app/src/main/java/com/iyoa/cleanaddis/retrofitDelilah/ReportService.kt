package com.iyoa.cleanaddis.retrofitDelilah

import com.iyoa.cleanaddis.data.report.Report
import com.iyoa.cleanaddis.data.user.User
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface ReportService {

    @GET("report/add")
    fun addReport(report: Report): Deferred<Report>

    @GET("/reports/{username}")
    fun getReportByUsername(@Path("username") username:String): Deferred<User>

    @GET("report/{uuid}")
    fun getReport(@Path("uuid") uuid:String){

    }
}