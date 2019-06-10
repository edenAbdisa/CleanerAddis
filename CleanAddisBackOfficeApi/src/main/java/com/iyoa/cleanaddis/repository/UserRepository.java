package com.iyoa.cleanaddis.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iyoa.cleanaddis.model.Label;
import com.iyoa.cleanaddis.model.User;

public interface UserRepository  extends JpaRepository<User, UUID>  {

	 
	@Query(value = "SELECT * FROM user "
			+ "WHERE username =:username "
			, nativeQuery = true)
	User getuser(@Param("username") String username);

}
