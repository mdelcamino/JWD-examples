package com.udacity.jdnd.c1.review;

import com.udacity.jdnd.c1.review.service.MessageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewApplication.class, args);
	}

	/*
	@Bean
	public String message(){
		System.out.println("creating message bean");
		return "Hello Spring";
	}
	@Bean
	public String uppercaseMessage( MessageService messageService){
		System.out.println("creating uppercasemessage bean");
		return messageService.upperCase();

	}

	@Bean
	public String lowercaseMessage(MessageService messageService){
		System.out.println("creating lowercasemessage bean");
		return messageService.tolowercase();
	}

	 */


}
