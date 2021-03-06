package com.relpy.services;

import java.util.List;

import com.relpy.models.Community;
import com.relpy.models.Thread;



public interface CommunityService {
	public List<Community> getAllCommunities();
	public Community getCommunityByTitle(String title);
	public Community addCommunity(Community com);
	public Community updateCommunity(Community com);
//	public void deleteCommunityByTitle(String title);
	public void deleteCommunityById(Long id);
	public void flush();
	Community getCommunityByID(long id);

}
