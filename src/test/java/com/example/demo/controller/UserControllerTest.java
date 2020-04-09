package com.example.demo.controller;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import static org.mockito.ArgumentMatchers.*;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@SpringBootTest
class UserControllerTest {
	@Mock
	UserService userService;
	@InjectMocks
	UserController userController;
	@Test
	void testCreateUserPositive() {
		User user= new User("Abhishek", 101);
		when(userService.validateUsername((User)notNull())).thenReturn(true);
		boolean result=userController.createUser(user);
		assertTrue(result);
	}
	@Test
	void testcreateUserNegative() {
		User user= new User("asfd", 101);
		when(userService.validateUsername((User)notNull())).thenReturn(false);
		boolean result=userController.createUser(user);
		assertFalse(result);
	}

}
