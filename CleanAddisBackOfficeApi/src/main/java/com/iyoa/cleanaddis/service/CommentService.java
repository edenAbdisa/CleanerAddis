package com.iyoa.cleanaddis.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.iyoa.cleanaddis.model.Comment;
import com.iyoa.cleanaddis.model.Post;
import com.iyoa.cleanaddis.repository.CommentRepository;
import com.iyoa.cleanaddis.repository.PostRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;

	public List<Comment> getAllCommentOfPost(UUID postUuid) {
		
		return commentRepository.getAllCommentOfPost(postUuid);
	}

	public Comment saveComment(Comment comment) {
		 
		return commentRepository.save(comment);
	}
	
}
