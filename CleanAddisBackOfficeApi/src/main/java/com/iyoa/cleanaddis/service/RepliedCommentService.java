package com.iyoa.cleanaddis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iyoa.cleanaddis.repository.PostRepository;
import com.iyoa.cleanaddis.repository.RepliedCommentRepository;

@Service
public class RepliedCommentService {

	@Autowired
	private RepliedCommentRepository repliedCommentRepository;
	
}
