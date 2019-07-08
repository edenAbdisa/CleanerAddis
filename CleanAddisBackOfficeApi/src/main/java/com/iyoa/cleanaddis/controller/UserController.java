package com.iyoa.cleanaddis.controller;

import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iyoa.cleanaddis.error.DataNotFoundException;
import com.iyoa.cleanaddis.json.PostJson;
import com.iyoa.cleanaddis.json.UserJson;
import com.iyoa.cleanaddis.model.Post;
import com.iyoa.cleanaddis.model.User;
import com.iyoa.cleanaddis.service.RoleService;
import com.iyoa.cleanaddis.service.UserService;
import com.iyoa.cleanaddis.util.ImageParser;
import com.mysql.cj.log.Log;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/user")
 @Slf4j
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	
	private ImageParser imageParser;
	
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
	
	@PostMapping(value="/create",consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<User> createUser(@RequestPart("file") MultipartFile file,@RequestPart("user") String userPayload) throws JsonParseException, JsonMappingException, IOException{
		UserJson userJson = new ObjectMapper().readValue(userPayload, UserJson.class);
		
		
		User user = new User();
		imageParser = new ImageParser();
		String imageUrl = imageParser.saveToDisk(file);
    	user.setUsername(userJson.getUsername());
    	user.setRole(roleService.getRoleByName(userJson.getRole()));
    	user.setPhoneNumber(userJson.getPhoneNumber());
    	user.setPassword(userJson.getPassword());
    	user.setLastVisit(Date.from(Instant.now()));
    	user.setLastName(userJson.getLastName());
    	user.setIsBlocked(userJson.getIsBlocked());
    	user.setIsActivated(userJson.getIsActivated());
    	user.setImagePath(imageUrl);
    	user.setFirstName(userJson.getFirstName());
    	user.setEmail(userJson.getEmail());
    	user.setActivatedDate(Date.from(Instant.now()));
    	return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.OK);

		
}
	@GetMapping(value = "/get/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username ) throws DataNotFoundException {
		User user=userService.getuser(username);
		log.info(user.toString());
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	@GetMapping(value = "/get/id/{uuid}")
    public ResponseEntity<User> getUserById(@PathVariable("uuid") UUID uuid ) throws DataNotFoundException {
		
		User user = userService.findUserById(uuid).get();
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@GetMapping(value = "/all")
    public ResponseEntity<List<User>> getUsers() throws DataNotFoundException {
		
		return new ResponseEntity<List<User>>(userService.findAll(), HttpStatus.OK);
	}
	
	public boolean checkAvailability(UUID id) {
		boolean isAvaliable = false;
		User user = userService.findUserById(id).get();
		if(user!=null) {
			isAvaliable = true;
		}
		return isAvaliable;
		
	}
	
	@PutMapping(value="/edit/{uuid}",consumes= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<User> editUsername(@PathVariable("uuid") UUID uuid,@RequestBody User user){
		boolean isEditable = checkAvailability(uuid);
		ResponseEntity<User> response = null;
		if(isEditable) {
			User editedUser = userService.findUserById(uuid).get();
			
			editedUser.setUsername(user.getUsername());
			response = new ResponseEntity<User>(editedUser,HttpStatus.OK);
			
		}
		return response;
	}
	
	@DeleteMapping(value ="/delete/{uuid}",consumes= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> deleteUsername(@PathVariable("uuid") UUID uuid,@RequestBody User user){
		boolean isDeletable = checkAvailability(uuid);
		if(isDeletable) {
			User deletedUser = userService.findUserById(uuid).get();
			userService.deleteUser(deletedUser);
			return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Not deleted",HttpStatus.NOT_FOUND);
			
		}
	
	}
	
}
