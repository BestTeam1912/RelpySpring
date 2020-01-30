package com.relpy.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.relpy.daos.ThreadDAO;
import com.relpy.models.Thread;
import com.relpy.services.ThreadService;

@RestController
@RequestMapping("/thread")
public class ThreadController {
	@Autowired
	private ThreadService threadService;
	
	@PostMapping("/add")
	public Thread addThread(@RequestBody Thread thread) {
		thread.setDateCreated(new Date());
		return threadService.addThread(thread);
	}
	
}
