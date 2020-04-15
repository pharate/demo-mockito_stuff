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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
	@Test //modify this case to check db insertion
	void testCreateUserPositive() {
		List<Project> projectList = new ArrayList<Project>();
		projectList.add(new Project("p1", null, "firstProject"));
		projectList.add(new Project("p4", null, "fourthProject"));
		projectList.add(new Project("p4", null, "fifthProject"));
		User user = new User("abhishek", 101, projectList);
		when(userService.validateUsername((User) notNull())).thenReturn(true);
		ResponseEntity<User> savedUser = userController.createUser(user);
		assertEquals(HttpStatus.CREATED, savedUser.getStatusCode());
	}

	@Test //modify this case to check db insertion
	void testcreateUserNegative() {
		User user = new User();
		when(userService.validateUsername((User) notNull())).thenReturn(false);
		ResponseEntity<User> savedUser = userController.createUser(user);
		assertNotEquals(HttpStatus.CREATED, savedUser.getStatusCode());
	}

}
