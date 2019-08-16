package com.iyoa.cleanaddis.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iyoa.cleanaddis.model.Article;
import com.iyoa.cleanaddis.model.Category;
import com.iyoa.cleanaddis.model.Label;
import com.iyoa.cleanaddis.service.CategoryService;
import com.iyoa.cleanaddis.service.LabelService;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private LabelService labelService;
	
	@PostMapping(value = "/create")
	    public ResponseEntity<Category> createArticlePost(@Valid @RequestBody Category category){
		  	boolean isAvail = checkAvailability(category);
		  	if(isAvail) {
		  		return new ResponseEntity<>(categoryService.findCategoryByName(category.getName()),HttpStatus.OK);
		  	}
		  	else {
			categoryService.Save(category);
	        return new ResponseEntity<>(category, HttpStatus.OK);
		  	}
	    }
	  
	  
	  @GetMapping(value="/get")
	  public ResponseEntity<List<Category>> getAllCategories(){
		  return new ResponseEntity<>(categoryService.getAllCategories(),HttpStatus.OK);
	  }
	  
	  @GetMapping(value="/get/{uuid}")
	  public ResponseEntity<Category> getCategoryById(@PathVariable("uuid") UUID uuid ){
		 
		  Category category = categoryService.findById(uuid).get();
		  return new ResponseEntity<>(category,HttpStatus.OK); 
	  }
	  
	  @GetMapping(value="/{name}")
	  public ResponseEntity<Category> getCategoryByName(@PathVariable("name") String name ){
		  
		  Category category = categoryService.findCategoryByName(name);
		  return new ResponseEntity<>(category,HttpStatus.OK); 
	  }
	  
	  public Label getLabelByName(String name) {
		  return labelService.getLabelByName(name);
	  }
	  
	  public boolean checkAvailability(Category category) {
		  boolean isCategoryAvailable = true;
		  Category availCategory = categoryService.findCategoryByName(category.getName());
		  if(availCategory.equals(null)) {
			  isCategoryAvailable = false;
		  }
		  return isCategoryAvailable;
	  }

}
