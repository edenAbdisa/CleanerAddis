package com.iyoa.cleanaddis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iyoa.cleanaddis.json.PostJson;
import com.iyoa.cleanaddis.json.UserJson;
import com.iyoa.cleanaddis.model.Post;
import com.iyoa.cleanaddis.model.User;
import com.iyoa.cleanaddis.service.RoleService;
import com.iyoa.cleanaddis.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	
	@PostMapping(value="/addUser", consumes = "application/json")
    public ResponseEntity<User> addUser(@RequestBody UserJson userJson) {
    	User user=new User();
    	user.setUsername(userJson.getUsername());
    	user.setRole(roleService.getRoleByName(userJson.getRole()));
    	user.setPhoneNumber(userJson.getPhoneNumber());
    	user.setPassword(userJson.getPassword());
    	user.setLastVisit(userJson.getLastVisit());
    	user.setLastName(userJson.getLastName());
    	user.setIsBlocked(userJson.getIsBlocked());
    	user.setIsActivated(userJson.getIsActivated());
    	user.setImagePath(userJson.getImagePath());
    	user.setFirstName(userJson.getFirstName());
    	user.setEmail(userJson.getEmail());
    	user.setActivatedDate(userJson.getActivatedDate());
    	
    	return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.OK);
    }
	
}
