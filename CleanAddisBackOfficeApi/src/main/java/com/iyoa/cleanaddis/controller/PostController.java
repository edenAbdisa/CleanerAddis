package com.iyoa.cleanaddis.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iyoa.cleanaddis.error.DataNotFoundException;
import com.iyoa.cleanaddis.json.FriendJson;
import com.iyoa.cleanaddis.json.PostJson;
import com.iyoa.cleanaddis.data.Friend;
import com.iyoa.cleanaddis.data.Post;
import com.iyoa.cleanaddis.service.PostService;

@RestController
@RequestMapping(value = "/post")
public class PostController {
	
	@Autowired
	private PostService postService;
		
	@PostMapping(value="/add", consumes = "application/json")
    public ResponseEntity<Post> addPost(@RequestBody PostJson postJson) {
    	Post post=new Post();
    	post.setUsername(postJson.getUsername());
    	post.setStatus(postJson.getStatus().toString());
    	post.setNoView(postJson.getNoView());
    	post.setNoLike(postJson.getNoLike());
    	post.setMediaUuid(postJson.getMediaUuid());
    	post.setDownloadable(postJson.getDownloadable());
    	post.setDate(postJson.getDate());
    	post.setCanBeViewedBy(postJson.getCanBeViewedBy().toString());
    	post.setAllowToBeUsedForArticle(postJson.getAllowToBeUsedForArticle());
    	return new ResponseEntity<Post>(postService.savePost(post), HttpStatus.OK);
    }
	@GetMapping(value = "/getPosts")
    public ResponseEntity<List<Post>> getPost() throws DataNotFoundException {
		return new ResponseEntity<List<Post>>(postService.getPosts(), HttpStatus.OK);
	}
	@GetMapping(value = "/getPost/{id}", consumes = "application/json")
    public ResponseEntity<Post> getPost(@PathVariable("id") UUID uuid) throws DataNotFoundException {
		return new ResponseEntity<Post>(postService.getPost(uuid), HttpStatus.OK);
	}
}
