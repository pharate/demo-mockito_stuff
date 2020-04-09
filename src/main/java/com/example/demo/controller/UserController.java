package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;

	public boolean createUser(User user) {
		System.out.println("Validating Username");
		boolean validationResult=userService.validateUsername(user);
		if(validationResult) {
			System.out.println("Valid user");
		}else {
			System.out.println("Invalid user");
		}
		return validationResult;
	}
}
