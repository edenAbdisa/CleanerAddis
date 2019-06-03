package com.iyoa.cleanaddis.viewModels.report

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.iyoa.cleanaddis.connectDatabase.report.ReportDatabase
import com.iyoa.cleanaddis.repository.report.ReportRepository

class ReportViewModel (application: Application): AndroidViewModel(application) {
    private val reportRepos: ReportRepository


    init{
        val  reportDAO = ReportDatabase.getDatabase(application).reportDao()
        reportRepos = ReportRepository(reportDAO)

    }
}