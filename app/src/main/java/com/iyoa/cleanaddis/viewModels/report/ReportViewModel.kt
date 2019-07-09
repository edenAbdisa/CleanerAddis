package com.iyoa.cleanaddis.viewModels.report

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.iyoa.cleanaddis.connectDatabase.DatabaseHelper
import com.iyoa.cleanaddis.connectDatabase.news.ReportDatabase
import com.iyoa.cleanaddis.data.report.Report
import com.iyoa.cleanaddis.repository.report.ReportRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class ReportViewModel(application: Application): AndroidViewModel(application) {

    private val reportRepository:ReportRepository
    lateinit var  allReports:LiveData<List<Report>>

    init{
        val db = ReportDatabase.getReportDatabase(application).reportDao()
        reportRepository = ReportRepository(db)

        allReports = reportRepository.getAllReport()
    }

    fun addReport(report:Report) = viewModelScope.launch {

        reportRepository.addReport(report)
    }
    fun addReports(report:List<Report>) = viewModelScope.async{
     reportRepository.addReports(report)
    }

    fun editReport(report:Report) = viewModelScope.launch {
        reportRepository.editReport(report)
    }
    fun deleteReport(report:Report) = viewModelScope.launch {
        reportRepository.deleteReport(report)
    }
}