package com.relpy;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.relpy.models.User;
import com.relpy.services.CommunityService;
import com.relpy.services.ThreadService;
import com.relpy.services.UserService;

@SpringBootApplication
public class RelpyApplication {
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(RelpyApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoData(ThreadService threadService, CommunityService communityService, UserService userService) {
		return args -> {					
			User user = new User();
			user.setUsername("balde");
			user.setPassword("123");
			userService.registerUser(user);
			
			user = new User();
			user.setUsername("jp");
			user.setPassword("1234565");
			userService.registerUser(user);
		};
	}
}
