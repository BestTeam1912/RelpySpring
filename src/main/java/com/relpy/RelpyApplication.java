package com.relpy;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Value;
=======
>>>>>>> b3
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.relpy.models.User;
import com.relpy.services.CommunityService;
import com.relpy.services.ThreadService;
import com.relpy.services.UserService;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class RelpyApplication {
<<<<<<< HEAD

	@Value("${defaultMoney}")
	private int defaultMoney;

=======
	
	
	
>>>>>>> b3
	public static void main(String[] args) {
		SpringApplication.run(RelpyApplication.class, args);
	}

	@RequestMapping("/")
	String helloWorld() {
		return "Hello World!";
	}

	@Bean
	public CommandLineRunner demoData(ThreadService threadService, CommunityService communityService,
			UserService userService) {
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
