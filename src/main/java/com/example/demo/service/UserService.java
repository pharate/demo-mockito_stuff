package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface UserService {
	public boolean validateUsername(User user);

	/*
	 * public String convertFromUserToString(User user); public User
	 * convertFromJasonToUser(String userJason);
	 */
	public List<User> getAllUsers();

	public User saveUser(User user);
}
