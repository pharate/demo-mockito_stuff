package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Project;
import com.example.demo.model.User;
import com.example.demo.service.UserServiceImpl;

@SpringBootApplication
public class DemoMokitoApplication {
	/*
	 * @Autowired UserController userController;
	 */

	public static void main(String[] args) {
		SpringApplication.run(DemoMokitoApplication.class, args);

		System.out.println("trying jason to User");
		String userJason = "{\"username\":\"abhishek\",\"id\":101,\"projectList\":"
				+ "[{\"projectId\":\"p1\",\"projectName\":\"firstProject\"},"
				+ "{\"projectId\":\"p4\",\"projectName\":\"fourthProject\"},"
				+ "{\"projectId\":\"p4\",\"projectName\":\"fifthProject\"}]}";
		User user = UserServiceImpl.convertFromJasonToUser(userJason);
		System.out.println(user);

		System.out.println("trying User to jason");
		// user=null;
		/*
		 * List<Project> projectList = new ArrayList<Project>(); projectList.add(new
		 * Project("p1", "firstProject")); projectList.add(new Project("p4",
		 * "fourthProject")); projectList.add(new Project("p4", "fifthProject")); User
		 * user = new User("abhishekPharate", 101, projectList);
		 */
		String convertedString = UserServiceImpl.convertFromUserToString(user);
		System.out.println(convertedString);
	}

}
