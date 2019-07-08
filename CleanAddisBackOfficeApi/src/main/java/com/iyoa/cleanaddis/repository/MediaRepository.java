package com.iyoa.cleanaddis.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iyoa.cleanaddis.model.Label;
import com.iyoa.cleanaddis.model.Media;



public interface MediaRepository extends JpaRepository<Media, UUID>{

	
	List<Media> findMediaByLabel(Label label);

	List<Media> findMediaByType(String type);

	Media findMediaByUrl(String url);


}
