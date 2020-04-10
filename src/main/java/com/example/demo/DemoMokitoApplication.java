package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		String userJason="{\"username\":\"abhishek\",\"id\":205}";
		User user=UserServiceImpl.convertFromJasonToUser(userJason);
		System.out.println(user);
		System.out.println("trying User to jason");
		String convertedString=UserServiceImpl.convertFromUserToString(user);
		System.out.println(convertedString);
	}

}
