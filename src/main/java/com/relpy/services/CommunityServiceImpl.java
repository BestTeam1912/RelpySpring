package com.relpy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relpy.daos.CommunityDAO;
import com.relpy.models.Community;
import com.relpy.models.Thread;
import java.util.List;



@Service
public class CommunityServiceImpl implements CommunityService {
	@Autowired
	private CommunityDAO comDao;


	@Override
	public List<Community> getAllCommunities() {
		// TODO Auto-generated method stub
		return comDao.findAll();
	}
	
	@Override
	public Community getCommunityByTitle(String title) {
		// TODO Auto-generated method stub
		return comDao.findByTitle(title);
	}
	
	@Override
	public Community getCommunityByID(long id) {
		// TODO Auto-generated method stub
		return comDao.findById(id).get();
	}

	@Override
	public Community addCommunity(Community com) {
		// TODO Auto-generated method stub
		return comDao.save(com);
	}
	
	@Override
	public Community updateCommunity(Community com) {
		//forloop -> threadservice.update(thread)
		return comDao.save(com);
	}

	@Override
	public void deleteCommunityById(Long id) {
		// TODO Auto-generated method stub
		comDao.deleteById(id);

	}

	public void flush() {
		comDao.flush();
	}


}
