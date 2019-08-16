package com.iyoa.cleanaddis.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iyoa.cleanaddis.model.Comment; 

public interface CommentRepository extends JpaRepository<Comment, UUID>{

	@Query(value = "SELECT * FROM comment "
			+ "WHERE post_uuid =:postUuid "
			, nativeQuery = true)
	List<Comment> getAllCommentOfPost(@Param("postUuid") UUID  postUuid);

}
