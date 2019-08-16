package com.iyoa.cleanaddis.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iyoa.cleanaddis.error.DataNotFoundException;
import com.iyoa.cleanaddis.json.FriendJson;
import com.iyoa.cleanaddis.json.PostJson;
import com.iyoa.cleanaddis.model.Friend;
import com.iyoa.cleanaddis.model.Post;
import com.iyoa.cleanaddis.service.MediaService;
import com.iyoa.cleanaddis.service.PostService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/post")
@Slf4j
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private MediaService mediaService;
	
	@PostMapping(value="/add", consumes = "application/json")
    public ResponseEntity<Post> addPost(@RequestBody PostJson postJson) {
    	Post post=new Post();
    	post.setUsername(postJson.getUsername());
    	post.setStatus(postJson.getStatus().toString());
    	post.setNoView(postJson.getNoView());
    	post.setNoLike(postJson.getNoLike());
    	post.setMedia(mediaService.findMediaByUUID(postJson.getMediaUuid()).get());
    	post.setDownloadable(postJson.getDownloadable());
    	post.setDate(postJson.getDate());
    	post.setCanBeViewedBy(postJson.getCanBeViewedBy().toString());
    	post.setAllowToBeUsedForArticle(postJson.getAllowToBeUsedForArticle());
    	return new ResponseEntity<Post>(postService.savePost(post), HttpStatus.OK);
    }
	@PutMapping(value="/increaseLike/{id}")
    public ResponseEntity<Post>  increaseNumberOfLikeOfPost(@PathVariable("id") UUID uuid) throws DataNotFoundException {
		//check if user has already liked the post
		Post post=postService.getPost(uuid);
		int noLike=post.getNoLike()+1;
		post.setNoLike(noLike);
		return new ResponseEntity<Post>(postService.savePost(post), HttpStatus.OK);
	}
	@GetMapping(value = "/getPosts")
    public ResponseEntity<List<Post>> getPost() throws DataNotFoundException {
		List<Post> listOfPost=postService.getPosts();
		log.info(listOfPost.toString());
		return new ResponseEntity<List<Post>>(listOfPost, HttpStatus.OK);
	}
	@GetMapping(value = "/getPost/{id}", consumes = "application/json")
    public ResponseEntity<Post> getPost(@PathVariable("id") UUID uuid) throws DataNotFoundException {
		return new ResponseEntity<Post>(postService.getPost(uuid), HttpStatus.OK);
	}
	
	@DeleteMapping (value = "/deletePost/{id}")
    public ResponseEntity< Void> deletePost(@PathVariable("id") String uuid) throws DataNotFoundException {
		
		UUID u=UUID.fromString(uuid);
		log.info(uuid);
		postService.deletePost(u);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
