package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Project;
import com.example.demo.model.User;
@SpringBootTest
class UserServiceImplTest {
	@Autowired
UserServiceImpl userServiceImpl;
	@Test
	void testValidateUsernamePositive() {
		List<Project> projectList= new ArrayList<Project>();
		projectList.add(new Project("p1","firstProject"));
		projectList.add(new Project("p4","fourthProject"));
		projectList.add(new Project("p4","fifthProject"));
		User user = new User("abhishek", 101, projectList);
		assertEquals(true,userServiceImpl.validateUsername(user));
	}
	@Test
	void testValidateUsernameNegativeBelowLowerLimit() {
		List<Project> projectList= new ArrayList<Project>();
		projectList.add(new Project("p1","firstProject"));
		projectList.add(new Project("p4","fourthProject"));
		projectList.add(new Project("p4","fifthProject"));
		User user = new User("a", 101, projectList);
		assertEquals(false,userServiceImpl.validateUsername(user));
	}
	@Test
	void testValidateUsernameNegativeAboveUpperLimit() {
		List<Project> projectList= new ArrayList<Project>();
		projectList.add(new Project("p1","firstProject"));
		projectList.add(new Project("p4","fourthProject"));
		projectList.add(new Project("p4","fifthProject"));
		User user = new User("abhishekPharate", 101, projectList);;
		assertEquals(false,userServiceImpl.validateUsername(user));
	}
	@Test
	void testValidateUsernameNegativeUpperLimitCornerCase() {
		//fail("Not yet implemented");
		List<Project> projectList= new ArrayList<Project>();
		projectList.add(new Project("p1","firstProject"));
		projectList.add(new Project("p4","fourthProject"));
		projectList.add(new Project("p4","fifthProject"));
		User user = new User("abhishekPh", 101, projectList);
		assertEquals(false,userServiceImpl.validateUsername(user));
	}
	@Test
	void testValidateUsernameNegativeLowerLimitCornerCase() {
		List<Project> projectList= new ArrayList<Project>();
		projectList.add(new Project("p1","firstProject"));
		projectList.add(new Project("p4","fourthProject"));
		projectList.add(new Project("p4","fifthProject"));
		User user = new User("abh", 101, projectList);
		assertEquals(false,userServiceImpl.validateUsername(user));
	}
	//@Disabled
	@Test
	void testConvertFromUserToStringPositive() {
		List<Project> projectList= new ArrayList<Project>();
		projectList.add(new Project("p1","firstProject"));
		projectList.add(new Project("p4","fourthProject"));
		projectList.add(new Project("p4","fifthProject"));
		User user = new User("abhishekPharate", 101, projectList);
		String convertedString=UserServiceImpl.convertFromUserToString(user);
		assertTrue(convertedString instanceof String && convertedString.length()>0);
	}
	@Test
	void testConvertFromUserToStringNullUserPositive() {
		User user = null;
		String convertedString=UserServiceImpl.convertFromUserToString(user);
		assertEquals(null, convertedString);
	}
	@Test
	void testConvertFromUserToStringEmptyUser() {
		User user = new User();
		String convertedString=UserServiceImpl.convertFromUserToString(user);
		assertEquals("{\"username\":null,\"id\":0,\"projectList\":null}", convertedString);
	}
	//@Disabled
	@Test
	void testConvertFromJasonToUserPositive() {
		List<Project> projectList= new ArrayList<Project>();
		projectList.add(new Project("p1","firstProject"));
		projectList.add(new Project("p4","fourthProject"));
		projectList.add(new Project("p4","fifthProject"));
		User expectedUser = new User("abhishek", 101, projectList);
		
		String userJason = "{\"username\":\"abhishek\",\"id\":101,\"projectList\":"
				+ "[{\"projectId\":\"p1\",\"projectName\":\"firstProject\"},"
				+ "{\"projectId\":\"p4\",\"projectName\":\"fourthProject\"},"
				+ "{\"projectId\":\"p4\",\"projectName\":\"fifthProject\"}]}";
		User user=UserServiceImpl.convertFromJasonToUser(userJason);
		assertEquals(expectedUser, user);
	}

}
