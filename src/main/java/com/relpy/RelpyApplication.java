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

			
			
//			Community Mock Service

//			Community com;
//			Thread thread = new Thread();
//			int uniqueNumber = 0;
//			
//			com = new Community();
//			com.setTitle("funny" + uniqueNumber);
//			com.setDescription("relpy/funny description haha" + uniqueNumber);
//			com.setDateCreated(new Date());
//			com.setThreads(new ArrayList<Thread>());

//			Thread Testing
//
//			for (int i = 0; i < 5; i++) {
//				thread = new Thread();
//				thread.setTitle("This is a thread title" + i);
//				thread.setDescription("This is a thread description" + i);
//				thread.setDateCreated(new Date());
//				com.getThreads().add(thread);
//				threadService.addThread(thread);
//			}
//			communityService.addCommunity(com);
//			uniqueNumber++;
			
//			com = new Community();
//			com.setTitle("funny" + uniqueNumber);
//			com.setDescription("relpy/funny description haha" + uniqueNumber);
//			com.setDateCreated(new Date());
//			com.setThreads(new ArrayList<Thread>());
			
//			Thread Testing
			
//			for (int i = 0; i < 2; i++) {
//				thread = new Thread();
//				thread.setTitle("This is a thread title" + i);
//				thread.setDescription("This is a thread description" + i);
//				thread.setDateCreated(new Date());
//				com.getThreads().add(thread);
//				threadService.addThread(thread);
//			}
//			communityService.addCommunity(com);
//			uniqueNumber++;
			
//			com = new Community();
//			com.setTitle("funny" + uniqueNumber);
//			com.setDescription("relpy/funny description haha" + uniqueNumber);
//			com.setDateCreated(new Date());
//			com.setThreads(new ArrayList<Thread>());
			
//			Thread Testing
			
//			for (int i = 0; i < 2; i++) {
//				thread = new Thread();
//				thread.setTitle("This is a thread title" + i);
//				thread.setDescription("This is a thread description" + i);
//				thread.setDateCreated(new Date());
//				com.getThreads().add(thread);
//				threadService.addThread(thread);
//			}
//			communityService.addCommunity(com);
//			uniqueNumber++;
			
			
			User user = new User();
			user.setUsername("balde");
			user.setPassword("123");
			userService.registerUser(user);
//			Thread thread = new Thread();
//			thread.setTitle("A new thread title, its different");
//			thread.setDescription("Some description");
//			thread.setMoneyMap(new HashMap<Long, Integer>());
//			thread.getMoneyMap().put(user.getId(), defaultMoney);
//			threadService.addThread(thread);
			
			user = new User();
			user.setUsername("jp");
			user.setPassword("1234565");
			userService.registerUser(user);
		};
	}
/////////////////////////////////////////////////////////////////
////https://stackoverflow.com/questions/51811372/why-aop-does-not-work-in-my-spring-boot-application
/////////////////////////////////////////////////////////////////
//	@Bean ThreadService threadService() {
//		return new ThreadServiceImpl();
//	}
//	
//	@Bean UserService userService() {
//		return new UserServiceImpl();
//	}
//	
//	@Bean CommunityService communityService() {
//		return new CommunityServiceImpl();
//	}
//	
//	@Bean ProxyCommentBO proxyCommentBO() {  
//		return new ProxyCommentBO();
//	}
}
