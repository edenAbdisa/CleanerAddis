package com.iyoa.cleanaddis.service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iyoa.cleanaddis.model.Article;
import com.iyoa.cleanaddis.model.Media;
import com.iyoa.cleanaddis.repository.MediaRepository;

@Service
public class MediaService {

	@Autowired
	private MediaRepository mediaRepos;
	
	public Media Save(Media media) {
		
		return mediaRepos.save(media);
		
	}
	
	public Optional<Media> findBId(UUID id) {
		
		return mediaRepos.findById(id);
	}
	
	
	
	public List<Media> saveAll(List<Media> medias){
		return mediaRepos.saveAll(medias);
	}
	
}
