package com.iyoa.cleanaddis.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iyoa.cleanaddis.model.Friend;

public interface FriendRepository extends JpaRepository<Friend, UUID>{

	@Query(value = "SELECT * FROM friends "
			+ "WHERE username_acceptor =:acceptor AND username_requestor =:requestor"
			, nativeQuery = true)
	Friend findRequestorFriend(@Param("acceptor") String acceptor,@Param("requestor") String requestor);

	@Query(value = "SELECT * FROM friends "
			+ "WHERE username_acceptor =:acceptor "
			, nativeQuery = true)
	List<Friend> findMyFriends(@Param("acceptor") String acceptor);

}
