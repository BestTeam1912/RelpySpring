package com.relpy.services;

import com.relpy.models.User;

public interface UserService {
	public boolean login(User user);
	public boolean registerUser(User user);
	public boolean registerAdmin(User user);
	public User getUserById(Long id);
	public User getUserByName(String userName);
}
