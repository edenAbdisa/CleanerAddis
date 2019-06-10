package com.iyoa.cleanaddis.retrofit

import com.iyoa.cleanaddis.data.report.Report
import com.iyoa.cleanaddis.data.report.ReportData
import com.iyoa.cleanaddis.data.user.User
import retrofit2.Call

import retrofit2.http.GET
import retrofit2.http.Path

interface ReportService {

    @GET("report/add")
    fun addReport(report: ReportData): Call<Report>

    @GET("/reports/{username}")
    fun getReportByUsername(@Path("username") username:String): Call<User>

    @GET("report/{uuid}")
    fun getReport(@Path("uuid") uuid:String){

    }
}