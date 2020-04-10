package com.example.demo.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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

	public static String convertFromUserToString(User user) {
		String userToString = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			userToString= mapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userToString;
	}

	public static User convertFromJasonToUser(String userJason) {
		ObjectMapper mapper= new ObjectMapper();
		User user = null;
		try {
			user= mapper.readValue(userJason, User.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
