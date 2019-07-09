package com.iyoa.cleanaddis.data.report

import androidx.lifecycle.LiveData
import androidx.room.*
import com.iyoa.cleanaddis.data.news.Article

@Dao
interface ReportDAO {

    @Query("SELECT * FROM report WHERE uuid =:uuid")
    fun getReportByUuid(uuid: Long): LiveData<Report>


    @Query("SELECT * FROM report WHERE username=:username")
    fun getAllReports(username:String): LiveData<List<Report>>

    @Query("SELECT * FROM report")
    fun getAllReport(): LiveData<List<Report>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addReport(report: Report)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addReports(listOfReports: List<Report>)

     @Update
     fun updateReport(report: Report): Int

      @Delete
     fun deleteReport(report: Report):Int


}