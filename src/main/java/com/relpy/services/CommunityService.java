package com.relpy.services;

import java.util.List;

import com.relpy.models.Community;


public interface CommunityService {
	public List<Community> getAllCommunities();
	public Community getCommunityByTitle(String title);
	public Community addCommunity(Community com);
	public Community updateCommunity(Community com);
	public void deleteCommunityById(int id);

//	public Community getAnimalById(int id);

}
