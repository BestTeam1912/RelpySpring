package com.relpy.controllers;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.relpy.models.Community;
import com.relpy.models.Thread;
import com.relpy.services.CommunityService;
import com.relpy.services.ThreadService;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/community")
public class CommunityController {
	@Autowired
	private CommunityService service;
	
	@Autowired
	private ThreadService threadService;
	
	@GetMapping()
	public List<Community> getAllCommunities(){
		return service.getAllCommunities();	
	}
	
	@GetMapping("/{title}")
	public Community getCommunityByTitle(@PathVariable("title") String title){
		Community community = service.getCommunityByTitle(title);
		community.getThreads();
		return community;
	}
	
	@PostMapping("/add")
	public Community addCommunity(@RequestBody Community com) {
		return service.addCommunity(com);
	}
	@PutMapping("/update/{comid}")
	public Community updateCommunity(@PathVariable("comid") long comid, @RequestBody Thread thread) {
		Community com = service.getCommunityByID(comid);
		if(com== null) {
			System.out.println("community is null");
		}
//		if(com.getThreads()== null) {
//			System.out.println("community is null");
//		}
		threadService.addThread(thread);
		service.getCommunityByID(comid).getThreads().add(thread);
		return service.updateCommunity(com);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteCommunityById(@PathVariable("id") Long id){
		service.deleteCommunityById(id);
	}

}
