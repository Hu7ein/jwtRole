package com.husen.jwt.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.husen.jwt.entity.User;
import com.husen.jwt.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostConstruct
	public void initRolesAndUsers() {
		
		userService.initRolesAndUser();
	}
	
	@PostMapping({"registerNewUser"})
	public User registerNewUSer(@RequestBody User user) {
		
		return userService.registerNewUser(user);
	}
	
	@GetMapping({"/forAdmin"})
	@PreAuthorize("hasRole('Admin')")
	public String forAdmin() {
		return "This URL is only Accessible to the Admin";
	}
	
	@GetMapping({"/forUser"})
	@PreAuthorize("hasRole('User')")
	public String forUser() {
		return "This URL is only Accessible to the User";
	}
	
	@GetMapping({"/forBoth"})
	@PreAuthorize("hasAnyRole('Admin','User')")
	public String forBoth() {
		return "This URL is Accessible to User & Admin";
	}

}
