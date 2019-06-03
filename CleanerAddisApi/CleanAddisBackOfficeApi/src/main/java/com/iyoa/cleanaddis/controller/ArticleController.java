package com.iyoa.cleanaddis.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iyoa.cleanaddis.model.Article;
import com.iyoa.cleanaddis.service.ArticleService;



@RestController
@RequestMapping(value = "/article")
public class ArticleController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);
	
	    @Autowired
	    private ArticleService articleService;
	  
	  @PostMapping(value = "")
	    public ResponseEntity<Article> createArticlePost(
	            @Valid @RequestBody Article article)
	            {

	        articleService.Save(article);
	        return new ResponseEntity<>(article, HttpStatus.OK);
	    }


}
