package com.iyoa.cleanaddis.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iyoa.cleanaddis.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, UUID>{

}
