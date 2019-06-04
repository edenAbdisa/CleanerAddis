package com.iyoa.cleanaddis.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iyoa.cleanaddis.model.Media;
import com.iyoa.cleanaddis.repository.MediaRepository;

@Service
public class MediaService {
	
	@Autowired
	MediaRepository mediaRepository;

	public Media getMedia(UUID id) {
		// TODO Auto-generated method stub
		return mediaRepository.findById(id).get();
	}
}
