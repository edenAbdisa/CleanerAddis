package com.iyoa.cleanaddis.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.iyoa.cleanaddis.model.Article;
import com.iyoa.cleanaddis.model.Report;

public interface ReportRepository extends JpaRepository<Report, UUID> {
	@Query(value = "SELECT * FROM report "
			+ "WHERE username =:username "
			, nativeQuery = true)
	List<Report> findReportByUsername(String username);

}
