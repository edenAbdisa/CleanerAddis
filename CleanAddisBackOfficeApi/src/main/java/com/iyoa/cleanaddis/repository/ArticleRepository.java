package com.iyoa.cleanaddis.repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iyoa.cleanaddis.model.Article;


public interface ArticleRepository extends JpaRepository<Article, UUID> {


	
	
}