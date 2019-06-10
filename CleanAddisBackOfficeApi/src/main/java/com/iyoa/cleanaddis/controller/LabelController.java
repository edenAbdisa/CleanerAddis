package com.iyoa.cleanaddis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iyoa.cleanaddis.json.LabelJson;
import com.iyoa.cleanaddis.json.RoleJson;
import com.iyoa.cleanaddis.data.Label;
import com.iyoa.cleanaddis.data.Role;
import com.iyoa.cleanaddis.service.LabelService;
import com.iyoa.cleanaddis.service.RoleService;

@RestController
@RequestMapping(value = "/label")
public class LabelController {
	@Autowired
	private LabelService labelService;
	
	@PostMapping(value="/add", consumes = "application/json")
    public ResponseEntity<Label> addRole(@RequestBody LabelJson labelJson) {
		Label label=new Label();
		label.setLabelName(labelJson.getLabel());
		return new ResponseEntity<Label>(labelService.saveLabel(label), HttpStatus.OK);
	}
}
