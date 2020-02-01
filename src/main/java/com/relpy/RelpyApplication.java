package com.relpy;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.relpy.models.Community;
import com.relpy.models.Thread;
import com.relpy.models.User;
import com.relpy.services.CommunityService;
import com.relpy.services.ThreadService;
import com.relpy.services.UserService;

@SpringBootApplication
//@EnableAspectJAutoProxy
//@ComponentScan("com.relpy.aspects.*")
public class RelpyApplication {
	
	@Value("${defaultMoney}")
	private int defaultMoney;
	
	
	
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
