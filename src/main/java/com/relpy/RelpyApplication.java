package com.relpy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.relpy.models.Community;
import com.relpy.models.Thread;
import com.relpy.services.CommunityService;
import com.relpy.services.ThreadService;

@SpringBootApplication
public class RelpyApplication {

	public static void main(String[] args) {
		SpringApplication.run(RelpyApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoData(ThreadService threadService, CommunityService communityService) {
		return args -> {

//			Community Mock Service

			Community com;
			Thread thread;
			int uniqueNumber = 0;

			com = new Community();
			com.setTitle("funny" + uniqueNumber);
			com.setDescription("relpy/funny description haha" + uniqueNumber);
			com.setDateCreated(new Date());
			com.setThreads(new ArrayList<Thread>());

//			Thread Testing

			for (int i = 0; i < 5; i++) {
				thread = new Thread();
				thread.setTitle("This is a thread title" + i);
				thread.setDescription("This is a thread description" + i);
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
				thread.setTitle("This is a thread title" + i);
				thread.setDescription("This is a thread description" + i);
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
				thread.setTitle("This is a thread title" + i);
				thread.setDescription("This is a thread description" + i);
				thread.setDateCreated(new Date());
				com.getThreads().add(thread);
				threadService.addThread(thread);
			}
			communityService.addCommunity(com);
			uniqueNumber++;
		};
	}
}
