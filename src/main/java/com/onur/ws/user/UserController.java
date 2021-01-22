package com.onur.ws.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.onur.ws.shared.GenericResponse;

@RestController
public class UserController {

	// private static final Logger log =
	// LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@PostMapping("/api/1.0/users")
	@ResponseStatus(HttpStatus.CREATED)
	public GenericResponse createUser(@Valid @RequestBody User user) {
		userService.save(user);

		return new GenericResponse("user created");
	}

}
