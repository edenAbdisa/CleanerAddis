package com.iyoa.cleanaddis.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iyoa.cleanaddis.data.Category;
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
	

}
