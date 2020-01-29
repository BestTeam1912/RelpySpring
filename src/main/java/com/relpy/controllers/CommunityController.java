package com.relpy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.relpy.models.Community;
import com.relpy.services.CommunityService;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CommunityController {
	@Autowired
	private CommunityService service;
	
	@GetMapping("/community")
	public List<Community> getAllCommunities(){
	return service.getAllCommunities();	
	}
	
	@GetMapping("/community/{title}")
	public Community getCommunityByTitle(@PathVariable("title") String title){
		return service.getCommunityByTitle(title);
	}
	
	@PostMapping("/community")
	public Community addCommunity(@RequestBody Community com) {
		System.out.println(com);
		return service.addCommunity(com);
	}
	@PutMapping("/community/{title}")
	public Community updateCommunity(@RequestBody Community com) {
		return service.updateCommunity(com);
	}
	@DeleteMapping("/community/{id}")
	public void deleteCommunityById(@PathVariable("id") int id){
		service.deleteCommunityById(id);
	}

//	@GetMapping("/animal/{id}")
//	public Community getCommunityById(@PathVariable("id") int id){
//		return service.getAnimalById(id);
//	}
}
