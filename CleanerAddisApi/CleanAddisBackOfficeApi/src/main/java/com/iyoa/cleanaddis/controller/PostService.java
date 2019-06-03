package com.iyoa.cleanaddis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService  {

	@Autowired
	private PostRepository postRepository;
	
	public List<Post> getPosts(){
		return postRepository.findAll();
	}
}
