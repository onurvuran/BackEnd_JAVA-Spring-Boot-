package com.onur.ws;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.onur.ws.user.User;
import com.onur.ws.user.UserService;

@SpringBootApplication
public class WsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsApplication.class, args);
	}
	
	@Bean
	CommandLineRunner vreateInitialUser(UserService userService) {
		       return (args) -> {
				User user = new User();
				user.setUsername("onur");
				user.setDisplayName("dispaly1");
				user.setPassword("onur");
				userService.save(user);
		};
	}

}
