package com.iyoa.cleanaddis.repository.report

import androidx.lifecycle.LiveData
import com.iyoa.cleanaddis.data.report.Report
import com.iyoa.cleanaddis.data.report.ReportDAO

class ReportRepository( private val reportDAO: ReportDAO) {

    fun getReportByUuid(uuid:Long): LiveData<Report> = reportDAO.getReportByUuid(uuid)


    fun getAllReports(username:String): LiveData<List<Report>> = reportDAO.getAllReports(username)

    fun getAllReport(): LiveData<List<Report>> = reportDAO.getAllReport()


    fun addReport(report:Report) = reportDAO.addReport(report)

    fun editReport(report:Report) = reportDAO.updateReport(report)

    fun deleteReport(report:Report) = reportDAO.deleteReport(report)

    fun addReports(report: List<Report>)  = reportDAO.addReports(report)


}