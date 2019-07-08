package com.iyoa.cleanaddis.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iyoa.cleanaddis.model.Label;
import com.iyoa.cleanaddis.model.Media;
import com.iyoa.cleanaddis.repository.MediaRepository;

@Service
public class MediaService {


	@Autowired
	private MediaRepository mediaRepository;
	
	public Media Save(Media media) {
		
		return mediaRepository.save(media);
		
	}
	
	public Optional<Media> findMediaByUUID(UUID id) {
		return mediaRepository.findById(id);
		
	}
	
	public List<Media> findAllMedias(){
		return mediaRepository.findAll();
	}
	
	public List<Media> findMediaByLabel(Label label){
		return mediaRepository.findMediaByLabel(label);
	}
	
	public List<Media> findMediaByType(String type){
		return mediaRepository.findMediaByType(type);
	}
	
	public Media findMediaByUrl(String url) {
		return mediaRepository.findMediaByUrl(url);
	}
	
	
	
	public List<Media> saveAll(List<Media> medias){
		return mediaRepository.saveAll(medias);
	}
	

	

	

	public Media getMedia(UUID id) {
		// TODO Auto-generated method stub
		return mediaRepository.findById(id).get();
	}

}
