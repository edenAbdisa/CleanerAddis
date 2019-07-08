package com.iyoa.cleanaddis.service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

	public Optional<User> findUserById(UUID uuid) {
		return userRepos.findById(uuid);
	}

	public List<User> findAll() {
		return userRepos.findAll();
	}

	public void deleteUser(User deletedUser) {
		userRepos.delete(deletedUser);
	}
}
