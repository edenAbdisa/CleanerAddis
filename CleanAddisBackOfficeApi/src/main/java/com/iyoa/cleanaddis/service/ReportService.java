package com.iyoa.cleanaddis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iyoa.cleanaddis.repository.ReportRepository;
@Service
public class ReportService {

	@Autowired
	private ReportRepository reportRepos;
}
