package com.iyoa.cleanaddis.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iyoa.cleanaddis.model.Post;

public interface PostRepository extends JpaRepository<Post, UUID>{

}
