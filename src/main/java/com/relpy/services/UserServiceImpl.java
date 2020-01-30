package com.relpy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relpy.daos.UserDAO;
import com.relpy.models.User;

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
	public boolean registerUser(User user) {
		User compUser = userRepository.findByUsername(user.getUsername());
		if(compUser != null) {
			return false;
		}else {
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
