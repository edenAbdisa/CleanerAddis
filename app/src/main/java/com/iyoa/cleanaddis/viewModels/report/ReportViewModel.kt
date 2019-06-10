package com.iyoa.cleanaddis.viewModels.report

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.iyoa.cleanaddis.connectDatabase.DatabaseHelper
import com.iyoa.cleanaddis.data.report.Report
import com.iyoa.cleanaddis.repository.report.ReportRepository
import kotlinx.coroutines.launch

class ReportViewModel(application: Application): AndroidViewModel(application) {

    private val reportRepository:ReportRepository
    lateinit var  allReports:LiveData<List<Report>>

    init{
        val db = DatabaseHelper.getDatabase(application,"report").reportDAO()
        reportRepository = ReportRepository(db)
        //TODO later
        //allReports = reportRepository.getAllReports()
    }

    fun addReport(report:Report) = viewModelScope.launch {

        reportRepository.addReport(report)
    }

    fun editReport(report:Report) = viewModelScope.launch {
        reportRepository.editReport(report)
    }
    fun deleteReport(report:Report) = viewModelScope.launch {
        reportRepository.deleteReport(report)
    }
}