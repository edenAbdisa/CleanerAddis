package com.iyoa.cleanaddis.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iyoa.cleanaddis.model.Post;
import com.iyoa.cleanaddis.model.User;
import com.iyoa.cleanaddis.repository.UserRepository;
@Service
public class UserService {

	@Autowired
	private UserRepository userRepos;

	public User saveUser(User user) {
		return userRepos.save(user);
	}

	public User getuser(String username) {
		return userRepos.getuser(username);
	}
}
