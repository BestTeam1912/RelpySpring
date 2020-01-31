package com.relpy;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.relpy.models.Community;
import com.relpy.models.Thread;
import com.relpy.models.User;
import com.relpy.models.UserType;
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

			
			
//			Community Mock Service

			Community com;
			Thread thread = new Thread();
			int uniqueNumber = 0;
			
			com = new Community();
			com.setTitle("funny" + uniqueNumber);
			com.setDescription("relpy/funny description haha" + uniqueNumber);
			com.setDateCreated(new Date());
			com.setThreads(new ArrayList<Thread>());

//			Thread Testing

			for (int i = 0; i < 5; i++) {
				thread = new Thread();
				thread.setTitle("This is a thread title" + uniqueNumber);
				thread.setDescription("This is a thread description" + uniqueNumber);
				thread.setDateCreated(new Date());
				com.getThreads().add(thread);
				threadService.addThread(thread);
			}
			communityService.addCommunity(com);
			uniqueNumber++;
			
			com = new Community();
			com.setTitle("funny" + uniqueNumber);
			com.setDescription("relpy/funny description haha" + uniqueNumber);
			com.setDateCreated(new Date());
			com.setThreads(new ArrayList<Thread>());
			
//			Thread Testing
			
			for (int i = 0; i < 2; i++) {
				thread = new Thread();
				thread.setTitle("This is a thread title" + uniqueNumber);
				thread.setDescription("This is a thread description" + uniqueNumber);
				thread.setDateCreated(new Date());
				com.getThreads().add(thread);
				threadService.addThread(thread);
			}
			communityService.addCommunity(com);
			uniqueNumber++;
			
			com = new Community();
			com.setTitle("funny" + uniqueNumber);
			com.setDescription("relpy/funny description haha" + uniqueNumber);
			com.setDateCreated(new Date());
			com.setThreads(new ArrayList<Thread>());
			
//			Thread Testing
			
			for (int i = 0; i < 2; i++) {
				thread = new Thread();
				thread.setTitle("This is a thread title" + uniqueNumber);
				thread.setDescription("This is a thread description" + uniqueNumber);
				thread.setDateCreated(new Date());
				com.getThreads().add(thread);
				threadService.addThread(thread);
			}
			communityService.addCommunity(com);
			uniqueNumber++;
			
			
			User user = new User();
			user.setUsername("balde");
			user.setPassword("123");
			userService.registerUser(user);
			thread = new Thread();
			thread.setTitle("A new thread title, its different");
			thread.setDescription("Some description");
			thread.setMoneyMap(new HashMap<User, Integer>());
			thread.getMoneyMap().put(user, 400);
			threadService.addThread(thread);
			
			user = new User();
			user.setUsername("jp");
			user.setPassword("1234565");
			userService.registerUser(user);
			
		};
	}
}
