package com.iyoa.cleanaddis.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iyoa.cleanaddis.model.Friend;
import com.iyoa.cleanaddis.model.Role;

public interface RoleRepository  extends JpaRepository<Role, UUID>  {

	@Query(value = "SELECT * FROM role "
			+ "WHERE role =:role "
			, nativeQuery = true)
	Role findByRole(@Param("role") String role);

}
