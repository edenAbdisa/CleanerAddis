package com.iyoa.cleanaddis.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iyoa.cleanaddis.model.Article;
import com.iyoa.cleanaddis.service.ArticleService;
import com.iyoa.cleanaddis.service.CategoryService;
import com.iyoa.cleanaddis.service.MediaService;



@RestController
@RequestMapping(value = "/article")
public class ArticleController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);
	
	    @Autowired
	    private ArticleService articleService;
	    @Autowired
	    private MediaService mediaService;
	    @Autowired
	    private CategoryService categoryService;
	    
	  
	  @PostMapping(value = "/create")
	    public ResponseEntity<Article> createArticlePost(@Valid @RequestBody Article article){
		  
		  	
	        articleService.Save(article);
	        return new ResponseEntity<>(article, HttpStatus.OK);
	    }
	  
	  @GetMapping(value = "/get-recent")
	    public ResponseEntity<Article> getRecentArticle(
	            @Valid @RequestBody Article article)
	            {
		  

	        articleService.Save(article);
	        return new ResponseEntity<>(article, HttpStatus.OK);
	    }
	  
	  @GetMapping(value = "/get/{uuid}")
	    public ResponseEntity<Article> getArticle(
	            @Valid @RequestBody Article article)
	            {

	        articleService.Save(article);
	        return new ResponseEntity<>(article, HttpStatus.OK);
	    }
	  
	  
	  @PutMapping(value = "/{uuid}/edit")
	    public ResponseEntity<Article> updateArticlePost(
	            @Valid @RequestBody Article article)
	            {

	        articleService.Save(article);
	        return new ResponseEntity<>(article, HttpStatus.OK);
	    }
	  
	  @DeleteMapping(value = "/{uuid}/delete")
	    public ResponseEntity<Article> deleteArticlePost(
	            @Valid @RequestBody Article article)
	            {

	        articleService.Save(article);
	        return new ResponseEntity<>(article, HttpStatus.OK);
	    }
	  
	  

}
