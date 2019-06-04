package com.iyoa.cleanaddis.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iyoa.cleanaddis.error.DataNotFoundException;
import com.iyoa.cleanaddis.json.FriendJson;
import com.iyoa.cleanaddis.model.Friend;
import com.iyoa.cleanaddis.model.Post;
import com.iyoa.cleanaddis.service.FriendService;
import com.iyoa.cleanaddis.service.PostService;

@RestController
@RequestMapping(value = "/friends")
public class FriendController {
	@Autowired
	private FriendService friendService;
	
	@GetMapping(value = "/friend/{username}", consumes = "application/json")
    public ResponseEntity<List<Friend>> findFriends(@PathVariable("username") String username) throws DataNotFoundException {
		return new ResponseEntity<List<Friend>>(friendService.getFriends(username), HttpStatus.OK);
	}
	
	@GetMapping(value ="/friend/{acceptor}/{requestor}", consumes = "application/json")
	public ResponseEntity<Friend> findFriendsById(@PathVariable("acceptor") String acceptor,
												  @PathVariable("requestor") String requestor ){
	 
		return new ResponseEntity<Friend>(friendService.getFriendByUsername(acceptor, requestor), HttpStatus.OK);
	}

    @PostMapping(value="/friend", consumes = "application/json")
    public ResponseEntity<Friend> addFriend(@RequestBody FriendJson friendJson) {
    	Friend friend=new Friend();
    	friend.setAcceptor(friendJson.getAcceptor());
    	friend.setRequestor(friendJson.getRequestor());
    	friend.setStatus(friendJson.getStatus());
    	return new ResponseEntity<Friend>(friendService.saveFriend(friend), HttpStatus.OK);
    }

}
