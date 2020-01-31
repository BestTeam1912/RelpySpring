package com.relpy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.relpy.models.Thread;
import com.relpy.models.User;
import com.relpy.services.ThreadService;

@RestController
@RequestMapping("/thread")
public class ThreadController {
	@Autowired
	private ThreadService threadService;
	
	@PostMapping("/add")
	public Thread addThread(@RequestBody Thread thread) {
		return threadService.addThread(thread);
	}
	
	
	@GetMapping("/get/{id}")
	public Thread getThreadById(@PathVariable long id) {
		return threadService.getThreadById(id);
	}
	
	@GetMapping("/get")
	public List<Thread> getAllThreads(){
		return threadService.getAllThreads();
	}
	
	@GetMapping("/get/currency/{threadId}/{userId}")
	public int getUserCurrency(@PathVariable long threadId, @PathVariable long userId ) {
		return threadService.getUserCurrency(threadId, userId);
	}
	
	@PostMapping("/add/user/{threadId}")
	public void addUserToThread(@PathVariable long threadId, @RequestBody User user) {
		threadService.addUserToThread(threadId, user);
	}
	
}
