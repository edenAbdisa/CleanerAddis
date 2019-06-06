package com.iyoa.cleanaddis.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iyoa.cleanaddis.model.Label;
import com.iyoa.cleanaddis.model.Role;

public interface LabelRepository extends JpaRepository<Label, UUID>{
 
	@Query(value = "SELECT * FROM label "
			+ "WHERE label_name =:label "
			, nativeQuery = true)
	Label findByLabel(@Param("label") String label);

}
