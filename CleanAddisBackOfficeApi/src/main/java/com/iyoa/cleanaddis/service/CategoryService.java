package com.iyoa.cleanaddis.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iyoa.cleanaddis.model.Category;
import com.iyoa.cleanaddis.repository.CategoryRepository;

@Service 
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepos;
	
	public Category Save(Category category) {
		
		return categoryRepos.save(category);
		
		}
	
	public Optional<Category> findById(UUID id){
		return categoryRepos.findById(id);
	}
	
	public List<Category> getAllCategories(){
		return categoryRepos.findAll();
	}

	public Category findCategoryByName(String name) {
		return categoryRepos.findCategoryByName(name);
	}
	

}
