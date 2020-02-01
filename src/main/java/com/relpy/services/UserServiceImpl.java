package com.relpy.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relpy.daos.UserDAO;
import com.relpy.models.User;
import com.relpy.models.UserType;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userRepository;
	
	@Override
	public boolean login(User user) {
		User compUser = userRepository.findByUsername(user.getUsername());
		if(compUser != null) {
			if(user.getPassword().equals(compUser.getPassword())) {
				return true;
			} else {
				return false;
			}
		}else {
			return false;
		}
		
	}
	
	@Override
	public boolean registerAdmin(User user) {
		User compUser = userRepository.findByUsername(user.getUsername());
		if(compUser != null) {
			return false;
		}else {
			user.setDateCreated(new Date());
			user.setType(UserType.Admin);
			userRepository.save(user);
			return true;
		}
	}

	@Override
	public boolean registerUser(User user) {
		User compUser = userRepository.findByUsername(user.getUsername());
		if(compUser != null) {
			return false;
		}else {
			user.setDateCreated(new Date());
			user.setType(UserType.User);
			userRepository.save(user);
			return true;
		}
		
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public User getUserByName(String userName) {
		return userRepository.findByUsername(userName);
	}



}
