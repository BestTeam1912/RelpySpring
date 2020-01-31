package com.relpy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.relpy.models.Thread;
import com.relpy.models.Transaction;
import com.relpy.models.User;
import com.relpy.services.ThreadService;

@RestController
@RequestMapping("/thread")
@CrossOrigin("http://localhost:4200")
public class ThreadController {
	@Autowired
	private ThreadService threadService;
	
	@PostMapping(path="/add")
	public Thread addThread(@RequestBody Thread thread) {
		return threadService.addThread(thread);
	}
	
	@GetMapping("/get")
	public List<Thread> getAllThreads(){
		return threadService.getAllThreads();
	}
	
	@GetMapping("/get/{id}")
	public Thread getThreadById(@PathVariable long id) {
		return threadService.getThreadById(id);
	}	
	
	@GetMapping("/get/currency/{threadId}/{userId}")
	public int getUserCurrency(@PathVariable long threadId, @PathVariable long userId ) {
		return threadService.getUserCurrency(threadId, userId);
	}
	
	@PostMapping(path="/add/user/{threadId}")
	public void addUserToThread(@PathVariable long threadId, @RequestBody User user) {
		threadService.addUserToThread(threadId, user);
	}
	
	@PutMapping("/reduce/currency")
	public void reduceUserCurrency(@RequestBody Transaction transaction) {
		threadService.reduceUserCurrency(transaction.getThreadId(), transaction.getUserId(), transaction.getAmount());
	}
}
