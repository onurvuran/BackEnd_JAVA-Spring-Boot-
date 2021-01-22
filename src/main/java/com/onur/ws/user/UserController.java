package com.onur.ws.user;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.onur.ws.error.ApiError;
import com.onur.ws.shared.GenericResponse;

import javax.validation.Valid;
@RestController
public class UserController {
	
	//private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	@PostMapping("/api/1.0/users")
	@ResponseStatus(HttpStatus.CREATED)
	public  GenericResponse createUser(@Valid @RequestBody User user) {
		userService.save(user);
		
		return new GenericResponse("user created");
	}
	
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST) 
	public ApiError handleValidationException(MethodArgumentNotValidException exception) {
		ApiError error = new ApiError(400,"Validation error","/api/1.0/users");
		Map<String,String>validationErrors = new HashMap<>();
		
		
		for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
			
		}
		error.setValidationErrors(validationErrors);
		return error;
	}
	
	}

	

