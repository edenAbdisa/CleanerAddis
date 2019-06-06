package com.iyoa.cleanaddis.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iyoa.cleanaddis.model.Friend;

public interface FriendsRepository extends JpaRepository<Friend, UUID>{

}
