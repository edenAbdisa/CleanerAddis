package com.iyoa.cleanaddis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iyoa.cleanaddis.model.Label;
import com.iyoa.cleanaddis.model.Role;
import com.iyoa.cleanaddis.repository.LabelRepository;
import com.iyoa.cleanaddis.repository.RoleRepository;

@Service
public class LabelService {
	@Autowired
	private LabelRepository labelRepos;

	public Label saveLabel(Label label) {
		
		return labelRepos.save(label);
	}
	
	public Label getLabelByName(String labelName) {
		return labelRepos.findByLabel(labelName);
	}
}
