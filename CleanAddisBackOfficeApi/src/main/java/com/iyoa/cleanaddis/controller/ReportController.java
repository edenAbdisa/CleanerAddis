package com.iyoa.cleanaddis.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iyoa.cleanaddis.json.RoleJson;
import com.iyoa.cleanaddis.model.Article;
import com.iyoa.cleanaddis.model.Report;
import com.iyoa.cleanaddis.model.Role;
import com.iyoa.cleanaddis.service.ReportService;

@RestController
@RequestMapping(value = "/report")
public class ReportController {
	
	@Autowired
	private ReportService reportService;
	
	@PostMapping(value="/add", consumes = "application/json")
    public ResponseEntity<Report> addReport(@RequestBody Report reportJson) {
		
		Report reportSaved = reportService.Save(reportJson);
		return new ResponseEntity<Report>(reportSaved, HttpStatus.OK);
	}
	
	 @GetMapping(value = "/reports/{username}")
	    public ResponseEntity<List<Report>> getAllReports(@PathVariable("username") String username)
	            {
		  	List<Report> reports = reportService.findReportByUsername(username);
	        return new ResponseEntity<>(reports, HttpStatus.OK);
	    }
	 
	 @GetMapping(value = "/report/{uuid}")
	    public ResponseEntity<Report> getReport(@PathVariable("uuid") UUID uuid)
	            {
		  	Report report = reportService.findById(uuid);
	        return new ResponseEntity<>(report, HttpStatus.OK);
	    }
	 
	

}
