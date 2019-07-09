package com.iyoa.cleanaddis.retrofit

import com.iyoa.cleanaddis.data.report.Report
import com.iyoa.cleanaddis.data.report.ReportData
import com.iyoa.cleanaddis.data.user.User
import retrofit2.Call
import retrofit2.http.DELETE

import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ReportService {

    @POST("report/add")
    fun addReport(report: ReportData): Call<Report>

    @GET("report/reports/{username}")
    fun getReportByUsername(@Path("username") username:String): Call<List<Report>>

    @GET("report/report/{uuid}")
    fun getReport(@Path("uuid") uuid:String)

    @DELETE("report/delete/{subject}")
    fun deleteReport(@Path("subject") subject:String):Call<String>
}