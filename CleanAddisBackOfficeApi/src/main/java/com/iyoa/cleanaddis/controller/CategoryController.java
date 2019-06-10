package com.iyoa.cleanaddis.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iyoa.cleanaddis.model.Article;
import com.iyoa.cleanaddis.model.Category;
import com.iyoa.cleanaddis.service.CategoryService;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	  @PostMapping(value = "/create")
	    public ResponseEntity<Category> createArticlePost(@Valid @RequestBody Category category){
		  categoryService.Save(category);
	        return new ResponseEntity<>(category, HttpStatus.OK);
	    }
	  
	  public boolean checkAvailability(Category category) {
		  //check if category is already in database
		   return false;
	  }

}
