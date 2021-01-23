package com.onur.ws.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.onur.ws.configuration.WsUserDetails;
import com.onur.ws.shared.Views;
import com.onur.ws.user.User;
import com.onur.ws.user.UserRepository;

@RestController
public class AuthController {
	@Autowired
	UserRepository userRepository;

	@PostMapping("/api/1.0/auth")
	@JsonView(Views.Base.class)
	ResponseEntity<?> handleAuthentication() {

		WsUserDetails userDetails = (WsUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		userDetails.getUser();
		return ResponseEntity.ok(userDetails.getUser());

	}
}
