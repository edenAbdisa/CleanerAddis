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
import com.iyoa.cleanaddis.json.CommentJson;
import com.iyoa.cleanaddis.json.PostJson;
import com.iyoa.cleanaddis.model.Comment;
import com.iyoa.cleanaddis.model.Post;
import com.iyoa.cleanaddis.service.CommentService;
import com.iyoa.cleanaddis.service.PostService;
import com.iyoa.cleanaddis.service.UserService;

@RestController
@RequestMapping(value = "/comment")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
		
	@Autowired
	private PostService postService;
	
	@Autowired
	private UserService userService;
	@GetMapping(value = "/getCommentsOfThispost/{postId}", consumes = "application/json")
	public ResponseEntity<List<Comment>> getAllCommentOfPost(@PathVariable("postId") UUID postUuid) throws DataNotFoundException {
		return new ResponseEntity<List<Comment>>(commentService.getAllCommentOfPost(postUuid), HttpStatus.OK);
	}
	
	@PostMapping(value="/add", consumes = "application/json")
    public ResponseEntity<Comment> addComment(@RequestBody CommentJson commentJson) {
		Comment comment=new Comment();
		comment.setCommentDate(commentJson.getCommentDate());
		comment.setNoLike(commentJson.getNoLike());
		comment.setPost(postService.getPost(commentJson.getPostUUID()).getUuid());
		comment.setStatus(commentJson.getStatus());
		comment.setText(commentJson.getText());
		comment.setUser(userService.getuser(commentJson.getUsername()));
    	return new ResponseEntity<Comment>(commentService.saveComment(comment), HttpStatus.OK);
    }
}
