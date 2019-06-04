package com.iyoa.cleanaddis.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iyoa.cleanaddis.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepos;
}
