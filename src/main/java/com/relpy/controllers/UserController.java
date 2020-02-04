package com.relpy.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.relpy.models.Sesh;
import com.relpy.models.User;
import com.relpy.services.UserService;

@RestController
@CrossOrigin(origins = "http://relpyrevature.s3-website.us-east-2.amazonaws.com")
public class UserController {
	
	@Autowired
	private UserService service;
	Sesh sesh = new Sesh();
	
	@PostMapping("/register")
	public User registerUser(@RequestBody User user) {
		return service.registerUser(user);
	}
	
	@PostMapping("/register/admin")
	public User registerAdmin(@RequestBody User user) {
		return service.registerAdmin(user);
	}
	
	@PostMapping("/login")
	public User login(@RequestBody User user, HttpSession session) {
		session.setAttribute("user", user);
//		System.out.println(session.getId());
		System.out.println(session.getAttribute("user"));
		return service.login(user);
	}
	
	@GetMapping("/login/sid")
	public Sesh getSessionId(HttpSession session) {
	    System.out.println(session.getId());
	    sesh.setSeshId(session.getId());
		return sesh;
	}
	
	@GetMapping("/login/{id}")
	public User getUserById(@PathVariable Long id) {
		return service.getUserById(id);
	}

}
