package com.iyoa.cleanaddis.controller;


import javax.validation.Valid;

import java.util.List;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iyoa.cleanaddis.model.Category;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iyoa.cleanaddis.error.DataNotFoundException;
import com.iyoa.cleanaddis.model.Friend;

import com.iyoa.cleanaddis.model.Media;
import com.iyoa.cleanaddis.service.MediaService;

@RestController
@RequestMapping(value = "/media")
public class MediaController {

	
	@Autowired
	private MediaService mediaService;
	
	  @PostMapping(value = "/create")
	    public ResponseEntity<Media> createArticlePost(@Valid @RequestBody Media media){
		  mediaService.Save(media);
	        return new ResponseEntity<>( media, HttpStatus.OK);
	    }
	  
	  public boolean checkAvailability(Media media) {
		  //check if media is already in database
		   return false;
	  }

	
	@GetMapping(value = "/Media/{id}", consumes = "application/json")
    public ResponseEntity<Media> findMedia(@PathVariable("id") UUID id) throws DataNotFoundException {
		return new ResponseEntity<Media>(mediaService.getMedia(id), HttpStatus.OK);
	}
	


}