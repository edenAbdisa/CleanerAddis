package com.iyoa.cleanaddis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iyoa.cleanaddis.json.PostJson;
import com.iyoa.cleanaddis.json.RoleJson;
import com.iyoa.cleanaddis.model.Post;
import com.iyoa.cleanaddis.model.Role;
import com.iyoa.cleanaddis.service.RoleService;

@RestController
@RequestMapping(value = "/role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@PostMapping(value="/add", consumes = "application/json")
    public ResponseEntity<Role> addRole(@RequestBody RoleJson roleJson) {
		Role role=new Role();
		role.setRoleName(roleJson.getRole());
		return new ResponseEntity<Role>(roleService.saveRole(role), HttpStatus.OK);
	}
	
	@GetMapping(value="/get")
	public ResponseEntity<List<Role>> getRoles(){
		return new ResponseEntity<List<Role>>(
				roleService.getAllRoles(),HttpStatus.OK
				);
	}
	@GetMapping(value="/get/{name}")
	public ResponseEntity<Role> getRole(@PathVariable("name") String name){
		
		return new ResponseEntity<Role>(
				roleService.getRoleByName(name),HttpStatus.OK
				);
	}
}
