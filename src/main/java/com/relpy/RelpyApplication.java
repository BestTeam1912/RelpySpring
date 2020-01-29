package com.relpy;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.relpy.models.Thread;
import com.relpy.services.ThreadService;

@SpringBootApplication
public class RelpyApplication {

	public static void main(String[] args) {
		SpringApplication.run(RelpyApplication.class, args);
	}
	@Bean
	public CommandLineRunner demoData(ThreadService threadService) {
		return args -> {
			
			Thread thread = new Thread();
			thread.setTitle("This is a thread title");
			thread.setDescription("This is a thread description");
			thread.setDateCreated(new Date());
			Thread thread2 = new Thread();
			thread2.setTitle("This is a thread title");
			thread2.setDescription("This is a thread description");
			thread2.setDateCreated(new Date());
			Thread thread3 = new Thread();
			thread3.setTitle("This is a thread title");
			thread3.setDateCreated(new Date());
			thread3.setDescription("This is a thread description");
			Thread thread4 = new Thread();
			thread4.setTitle("This is a thread title");
			thread4.setDescription("This is a thread description");
			thread4.setDateCreated(new Date());
			Thread thread5 = new Thread();
			thread5.setTitle("This is a thread title");
			thread5.setDescription("This is a thread description");
			thread5.setDateCreated(new Date());
			Thread thread6 = new Thread();
			thread6.setTitle("This is a thread title");
			thread6.setDescription("This is a thread description");
			thread6.setDateCreated(new Date());
			Thread thread7 = new Thread();
			thread7.setTitle("This is a thread title");
			thread7.setDescription("This is a thread description");
			thread7.setDateCreated(new Date());
			Thread thread8 = new Thread();
			thread8.setTitle("This is a thread title");
			thread8.setDescription("This is a thread description");
			thread8.setDateCreated(new Date());
			Thread thread9 = new Thread();
			thread9.setTitle("This is a thread title");
			thread9.setDescription("This is a thread description");
			thread9.setDateCreated(new Date());
			Thread thread10 = new Thread();
			thread10.setTitle("This is a thread title");
			thread10.setDescription("This is a thread description");
			thread10.setDateCreated(new Date());
			threadService.addThread(thread);
			threadService.addThread(thread2);
			threadService.addThread(thread3);
			threadService.addThread(thread4);
			threadService.addThread(thread5);		
			threadService.addThread(thread6);		
			threadService.addThread(thread7);		
			threadService.addThread(thread8);		
			threadService.addThread(thread9);		
			threadService.addThread(thread10);		
		};
	}
}
