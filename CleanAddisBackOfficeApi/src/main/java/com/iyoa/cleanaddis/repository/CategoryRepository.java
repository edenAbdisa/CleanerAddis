package com.iyoa.cleanaddis.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iyoa.cleanaddis.model.Category;

public interface CategoryRepository extends JpaRepository<Category, UUID> {

	Category findCategoryByName(String name);

}
