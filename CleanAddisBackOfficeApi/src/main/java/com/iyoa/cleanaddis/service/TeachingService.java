package com.iyoa.cleanaddis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iyoa.cleanaddis.repository.TeachingRepository;
@Service
public class TeachingService {
	@Autowired
	private TeachingRepository teachingRepos;
}
