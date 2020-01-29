package com.relpy;

import java.util.ArrayList;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RelpyApplication {

	public static void main(String[] args) {
		SpringApplication.run(RelpyApplication.class, args);
	}
//	@Bean
//	public CommandLineRunner sellerDemoData() {
//		return args -> {
//			System.out.println("Loool");
////			System.out.println("Generating the Seller info..");
////			Seller seller;
////			int id = 1;
////			seller = new Seller();
////			seller.setName(id++ + "_namio");
////			seller.setPassword("password");
////			seller.setConversations(new ArrayList<Conversation>());
////			seller.setReviews(new ArrayList<Review>());
////			sellerService.addSeller(seller);
////			seller = new Seller();
////			seller.setName(id++ + "_namio");
////			seller.setPassword("password");
////			seller.setConversations(new ArrayList<Conversation>());
////			seller.setReviews(new ArrayList<Review>());
////			sellerService.addSeller(seller);
////			seller = new Seller();
////			seller.setName(id++ + "_namio");
////			seller.setPassword("password");
////			seller.setConversations(new ArrayList<Conversation>());
////			seller.setReviews(new ArrayList<Review>());
////			sellerService.addSeller(seller);
//		};
//	}
}
