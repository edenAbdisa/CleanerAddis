package com.iyoa.cleanaddis.controller;


import javax.validation.Valid;

import java.io.IOException;
import java.util.List;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iyoa.cleanaddis.error.DataNotFoundException;
import com.iyoa.cleanaddis.json.MediaJson;
import com.iyoa.cleanaddis.model.Category;
import com.iyoa.cleanaddis.model.Friend;
import com.iyoa.cleanaddis.model.Label;
import com.iyoa.cleanaddis.model.Media;
import com.iyoa.cleanaddis.service.LabelService;
import com.iyoa.cleanaddis.service.MediaService;
import com.iyoa.cleanaddis.util.ImageParser;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@RestController
@RequestMapping(value = "/media")
public class MediaController {

	
	@Autowired
	private MediaService mediaService;
	@Autowired 
	private LabelService labelService;
	
	public MediaController(MediaService mediaServ) {
		mediaServ = new MediaService();
	}
	
	private ImageParser imageParser;

	  @PostMapping(value = "/create",consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
	
	    public ResponseEntity<Media> createArticlePost(@Valid @RequestBody Media media){
		  mediaService.Save(media);
	        return new ResponseEntity<>( media, HttpStatus.OK);
	    }
	  
	  public boolean checkAvailability(Media media) {
		  //check if media is already in database
		   return false;
	  }
	  
	  @PostMapping(value="/createMedia",consumes= {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
	  public ResponseEntity<Media> createMedia(@RequestPart("file") MultipartFile file,
			  @RequestPart("media") String mediaPayLoad
			  ) throws IOException{
				
		  MediaJson mediajson = new ObjectMapper().readValue(mediaPayLoad, MediaJson.class);
		  imageParser = new ImageParser();
		  String fileUrl = imageParser.saveToDisk(file);
		  Label label = labelService.getLabelByName(mediajson.getLabel());
		  //label.setLabelName("article");
		  Label savedLabel = labelService.saveLabel(label);
		  Media newMedia = new Media();
		  newMedia.setLabel(savedLabel);
		  newMedia.setType(mediajson.getType());
		  newMedia.setUrl(fileUrl);
		  newMedia.setDescription(mediajson.getDescription());
		  Media savedMedia = mediaService.Save(newMedia);
		  return new ResponseEntity<Media>(savedMedia,HttpStatus.OK);
		  
	  }

	
	@GetMapping(value="/get/{uuid}")
    public ResponseEntity<Media> findMedia(@PathVariable("uuid") UUID uuid) throws DataNotFoundException {
		java.util.Optional<Media> m = mediaService.findMediaByUUID(
				uuid);
		Media media = m.get();
		return new ResponseEntity<Media>(media, HttpStatus.OK);
	}
	
	@GetMapping(value="/get")
    public ResponseEntity<List<Media>> findAllMedia() throws DataNotFoundException {
		List<Media> media = mediaService.findAllMedias();
		return new ResponseEntity<List<Media>>(media, HttpStatus.OK);
	}
	
	@GetMapping(value="/get/{url}")
    public ResponseEntity<Media> findMedia(@PathVariable("uuid") String url) throws DataNotFoundException {
		Media media = mediaService.findMediaByUrl(url);
		return new ResponseEntity<Media>(media, HttpStatus.OK);
	}
}
