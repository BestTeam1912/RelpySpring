package com.relpy.services;

import com.relpy.models.User;

public interface UserService {
	public boolean login();
	public void registerUser(User user);
	public User getUserById(Long id);
}
