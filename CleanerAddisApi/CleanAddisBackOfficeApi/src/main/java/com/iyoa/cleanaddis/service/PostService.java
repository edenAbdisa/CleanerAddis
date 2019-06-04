package com.iyoa.cleanaddis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iyoa.cleanaddis.model.Post;
import com.iyoa.cleanaddis.repository.PostRepository;

@Service
public class PostService  {

	@Autowired
	private PostRepository postRepository;
	
	public List<Post> getPosts(){
		return postRepository.findAll();
	}
}
