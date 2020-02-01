package com.relpy.services;

import com.relpy.models.User;

public interface UserService {
	public User login(User user);
	public User registerUser(User user);
	public User registerAdmin(User user);
	public User getUserById(Long id);
	public User getUserByName(String userName);
}
