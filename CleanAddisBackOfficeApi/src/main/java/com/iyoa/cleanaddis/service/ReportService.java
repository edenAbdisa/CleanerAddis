package com.iyoa.cleanaddis.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iyoa.cleanaddis.model.Article;
import com.iyoa.cleanaddis.model.Report;
import com.iyoa.cleanaddis.repository.ReportRepository;
@Service
public class ReportService {

	@Autowired
	private ReportRepository reportRepos;
	
	public Report Save(Report report) {
		return reportRepos.save(report);
	}

	public List<Report> findAll() {
		return reportRepos.findAll();
	}

	public List<Report> findReportByUsername(String username) {
		return reportRepos.findReportByUsername(username);
	}

	public Report findById(UUID uuid) {
		// TODO Auto-generated method stub
		return reportRepos.getOne(uuid);
	}
}
