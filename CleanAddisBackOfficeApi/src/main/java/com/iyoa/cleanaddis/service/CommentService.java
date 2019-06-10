package com.iyoa.cleanaddis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iyoa.cleanaddis.repository.CommentRepository;
import com.iyoa.cleanaddis.repository.PostRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;
	
}
