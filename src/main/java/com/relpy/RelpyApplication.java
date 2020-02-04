package com.relpy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class RelpyApplication {
	public static void main(String[] args) {
		SpringApplication.run(RelpyApplication.class, args);
	}

	@RequestMapping("/")
	String helloWorld() {
		return "Hello World!";
	}
}
