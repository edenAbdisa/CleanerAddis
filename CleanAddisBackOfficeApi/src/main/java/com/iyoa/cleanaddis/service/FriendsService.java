package com.iyoa.cleanaddis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iyoa.cleanaddis.repository.FriendsRepository;

@Service
public class FriendsService{
	
	@Autowired
	private FriendsRepository friendsRepos;
	
	

}
