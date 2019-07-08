package com.iyoa.cleanaddis.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iyoa.cleanaddis.model.Friend;
import com.iyoa.cleanaddis.model.Post;
import com.iyoa.cleanaddis.repository.PostRepository;

@Service
public class PostService  {

	@Autowired
	private PostRepository postRepository;
	
	public List<Post> getPosts(){
		return postRepository.findAll();
	}

	public Post savePost(Post post) {
		return postRepository.save(post);
	}

	public Post getPost(UUID uuid) {
		return postRepository.getOne(uuid);
	}

	public void deletePost(UUID uuid) { 
		 postRepository.deleteById(uuid);
	}
}
