package com.iyoa.cleanaddis.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iyoa.cleanaddis.repository.UserRepository;
@Service
public class UserService {

	@Autowired
	private UserRepository userRepos;
}
