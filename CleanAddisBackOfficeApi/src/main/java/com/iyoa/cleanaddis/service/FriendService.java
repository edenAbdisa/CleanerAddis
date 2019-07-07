package com.iyoa.cleanaddis.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iyoa.cleanaddis.model.Friend;
import com.iyoa.cleanaddis.repository.FriendRepository;

@Service
public class FriendService {
	@Autowired
	private FriendRepository friendRepository;

	public List<Friend> getFriends(String username) {
		
		return friendRepository.findMyFriends(username);
	}

	public Friend getFriendByUsername(String acceptor ,String requestor) {
		// TODO Auto-generated method stub
		return friendRepository.findRequestorFriend(acceptor,requestor);
	}

	public Friend saveFriend(Friend friend) {
		return friendRepository.save(friend);
	}
	
	
}
