package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.User;

@Service
public class UserServiceImpl implements UserService{

	@Override
	public boolean validateUsername(User user) {
		boolean valid=true;
		String username=user.getUsername();
		if(username.length()<=4&&username.length()>=10) {
			valid = false;
		}
		return valid;
	}

}
