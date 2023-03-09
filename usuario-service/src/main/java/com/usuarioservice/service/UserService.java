package com.usuarioservice.service;

import java.util.List;

import com.usuarioservice.entity.User;

public interface UserService {

	public User createUser(User user);
	
	public List<User> getAll();
	
	public User findUserById(String id);
}
