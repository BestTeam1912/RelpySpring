package com.relpy.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
		Community com = comDao.findByTitle(title);
		
		if(com.getThreads().size()>1) {
			Collections.sort(com.getThreads(), new Comparator<Thread>() {
				  public int compare(Thread t1, Thread t2) {
				      return t2.getDateCreated().compareTo(t1.getDateCreated());
				  }
				});
			
			List<Thread> threads = new ArrayList<Thread>();
			for(int i = 0; i < com.getThreads().size() && i<10; i++) {
				threads.add(com.getThreads().get(i));
			}
			com.setThreads(threads);
		}
		return com;
	}
	
	@Override
	public Community getCommunityByID(long id) {
		return comDao.findById(id).get();
	}

	@Override
	public Community addCommunity(Community com) {
		// TODO Auto-generated method stub
		return comDao.save(com);
	}
	
	@Override
	public Community updateCommunity(Community com) {
		com = comDao.save(com);
		
		if(com.getThreads().size()>1) {
			Collections.sort(com.getThreads(), new Comparator<Thread>() {
				  public int compare(Thread t1, Thread t2) {
				      return t2.getDateCreated().compareTo(t1.getDateCreated());
				  }
				});
			
			List<Thread> threads = new ArrayList<Thread>();
			for(int i = 0; i < com.getThreads().size() && i<10; i++) {
				threads.add(com.getThreads().get(i));
			}
			com.setThreads(threads);
		}
		return com;
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
