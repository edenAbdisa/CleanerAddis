package com.iyoa.cleanaddis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iyoa.cleanaddis.error.DataNotFoundException;
import com.iyoa.cleanaddis.model.Post;
import com.iyoa.cleanaddis.service.PostService;

@RestController
@RequestMapping(value = "/post")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@GetMapping(value = "/getPost", consumes = "application/json")
    public ResponseEntity<List<Post>> getPost() throws DataNotFoundException {
		return new ResponseEntity<List<Post>>(postService.getPosts(), HttpStatus.OK);
	}
}