package com.iyoa.cleanaddis.controller;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iyoa.cleanaddis.json.ArticleJson;
import com.iyoa.cleanaddis.model.Article;
import com.iyoa.cleanaddis.model.User;
import com.iyoa.cleanaddis.service.ArticleService;
import com.iyoa.cleanaddis.service.CategoryService;
import com.iyoa.cleanaddis.service.MediaService;
import com.iyoa.cleanaddis.service.UserService;



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
	    @Autowired
	    private UserService userService;
	  
	  @PostMapping(value = "/create")
	  
	    public ResponseEntity<Article> createArticle(@RequestBody ArticleJson article){
		    Article savedArticle = new Article();
		    boolean isPublishable = checkUser(article.getPublisher());
		    if(isPublishable) {
		    	savedArticle.setPublisher(userService
		    	.getuser(article.getPublisher())		
		    			);
		    	savedArticle.setCategory(categoryService.findById(article.getCategory_uuid()).get());
		    	savedArticle.setMedia(mediaService.findMediaByUUID(article.getMediaUuid()).get());
		    	savedArticle.setText(article.getText());
		    	savedArticle.setTitle(article.getText());
		    	savedArticle.setViewCount(article.getViewCount());
		    	savedArticle.setPublishedStatus(article.getPublishedStatus());
		    	savedArticle = articleService.Save(savedArticle);
		    }
		 
	        return new ResponseEntity<Article>(savedArticle, HttpStatus.OK);
	    }
	  
	  @GetMapping(value="/get/{uuid}")
	  public ResponseEntity<Article> getArticle(@PathVariable("uuid") UUID uuid){
		  
		  Article article = articleService.findArticleById(uuid);
		  if(article!=null) {
			  return new ResponseEntity<Article>(article,HttpStatus.OK);
		  }
		else {
			return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
		}
	  }
	  
	  
	  
	  @GetMapping(value = "/articles")
	    public ResponseEntity<List<Article>> getAllArticles()
	            {
		  	List<Article> articles = articleService.findAll();

	       
	        return new ResponseEntity<>(articles, HttpStatus.OK);
	    }
	  
	  @GetMapping(value = "/get-recent")
	    public ResponseEntity<Article> getRecentArticle(
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
	  
	  @DeleteMapping(value = "/delete/{uuid}")
	    public ResponseEntity<String> deleteArticle(@PathVariable("uuid") UUID uuid)
	            {
		  ResponseEntity<String> response = null;
		  boolean isDeletable = checkArticle(uuid);
		  if(isDeletable) {
			
	        articleService.delete(articleService.findArticleById(uuid));
	        response = new ResponseEntity<>("Successfully Deleted", HttpStatus.OK);
	        
		  }
		  else {
			  response = new ResponseEntity<>("Not Deleted", HttpStatus.NOT_MODIFIED);
		  }
		  return response;
		  
	    }
	  
	  @PutMapping(value="/edit/{uuid}")
	  public ResponseEntity<Article> editArticle(@PathVariable("uuid")UUID uuid,@RequestBody ArticleJson article){
		  Article articleEditable = articleService.findArticleById(uuid);
		  boolean isEditable = checkArticle(articleEditable.getUuid());
		  ResponseEntity<Article> response = null;
		  if((isEditable) && (article.getTitle()!=null) ) {
			  articleEditable.setTitle(article.getTitle());
		  
		 
			  articleEditable.setText(article.getText());
		  
		  
			  articleEditable.setPublishedStatus(article.getPublishedStatus());
		  
		  
			  articleEditable.setPublisher(userService.getuser(article.getPublisher()));
		 
		  
			  articleEditable.setUpdater(userService.getuser(article.getUpdater()));
		  
			  articleEditable.setViewCount(article.getViewCount());
			  
		  
		  
			  articleEditable.setUpdatedDate(Date.from(Instant.now()));
			  Article edited = articleService.Save(articleEditable);
			  response = new ResponseEntity<>(edited,HttpStatus.OK);
		  }
		  
		return response;
		  
	  }
	  
	  @PutMapping(value="/publish/{uuid}")
	  public ResponseEntity<Article> publishArticle(@PathVariable("uuid")UUID uuid){
		  Article articlePublishable = articleService.findArticleById(uuid);
		  boolean isEditable = checkArticle(articlePublishable.getUuid());

		  if(isEditable) {
			  articlePublishable.setPublishedStatus("PUBLISHED");
			  articlePublishable.setPublishedDate(Date.from(Instant.now()));
			  articlePublishable = articleService.Save(articlePublishable);
		  }
		  return new ResponseEntity<Article>(articlePublishable,HttpStatus.OK);
	  }
	  
	  /*public boolean checkAvaliability(ArticleJson article) {
		  boolean isAvail = false;
		  Article availArticle = articleService.findArticleById(article.getUuid());
		  if(availArticle!=null) {
			  isAvail = true;
		  }
		  return isAvail;
	  }*/
	  public boolean checkUser(String user) {
		  boolean isAvail = false;
		  User availUser = userService.getuser(user);
		  if(availUser!=null) {
			  isAvail = true;
		  }
		  return isAvail;
	  }
	  
	  public boolean checkArticle(UUID uuid) {
		  boolean isAvail = false;
		  Article existingArticle = articleService.findArticleById(uuid);
		  if(existingArticle!=null) {
			  isAvail = true;
		  }
		 return isAvail;
	  }
	  

}
