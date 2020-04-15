package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("/user")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		System.out.println("Validating Username");
		boolean validationResult = userService.validateUsername(user);
		if (validationResult) {
			System.out.println("Valid user");
		} else {
			System.out.println("Invalid user");
		}
		ResponseEntity<User> entity;
		if (!validationResult) {
			entity = new ResponseEntity<User>(user, HttpStatus.BAD_REQUEST);
		} else {
			User dbSavedUser = userService.saveUser(user);
			entity = new ResponseEntity<User>(dbSavedUser, HttpStatus.CREATED);
		}
		return entity;
	}
}
