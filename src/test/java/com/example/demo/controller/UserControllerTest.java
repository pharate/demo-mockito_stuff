package com.example.demo.controller;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import static org.mockito.ArgumentMatchers.*;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Project;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@SpringBootTest
class UserControllerTest {
	@Mock
	UserService userService;
	@InjectMocks
	UserController userController;
	User user;

	/*
	 * @BeforeEach void testPrep() { List<Project> projectList= new
	 * ArrayList<Project>(); projectList.add(new Project("p1","firstProject"));
	 * projectList.add(new Project("p4","fourthProject")); projectList.add(new
	 * Project("p4","fifthProject")); User user = new User("abhishek", 101,
	 * projectList); }
	 */
	@Test
	void testCreateUserPositive() {
		List<Project> projectList= new ArrayList<Project>();
		projectList.add(new Project("p1","firstProject"));
		projectList.add(new Project("p4","fourthProject"));
		projectList.add(new Project("p4","fifthProject"));
		User user = new User("abhishek", 101, projectList);
		when(userService.validateUsername((User)notNull())).thenReturn(true);
		boolean result=userController.createUser(user);
		assertTrue(result);
	}
	@Test
	void testcreateUserNegative() {
		User user= new User();
		when(userService.validateUsername((User)notNull())).thenReturn(false);
		boolean result=userController.createUser(user);
		assertFalse(result);
	}

}
