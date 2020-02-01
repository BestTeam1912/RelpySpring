package com.relpy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.relpy.models.User;
import com.relpy.services.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/register")
	public boolean registerUser(@RequestBody User user) {
		return service.registerUser(user);
	}
	
	@PostMapping("/registerAdmin")
	public boolean registerAdmin(@RequestBody User user) {
		return service.registerAdmin(user);
	}

	
	@PostMapping("/login")
	public boolean login(@RequestBody User user) {
		return service.login(user);
	}
	
	@GetMapping("/login/{id}")
	public User getUserById(@PathVariable Long id) {
		return service.getUserById(id);
	}

}
