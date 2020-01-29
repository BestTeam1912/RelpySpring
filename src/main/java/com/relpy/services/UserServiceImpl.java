package com.relpy.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.relpy.daos.UserDAO;
import com.relpy.models.User;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userRepository;
	
	@Override
	public boolean login() {
		return false;
	}

	@Override
	public void registerUser(User user) {
		userRepository.save(user);
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.getUserById(id);
	}

}
