package com.onur.ws.user;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;
import com.onur.ws.shared.Views;

import lombok.Data;


@Data
@Entity
public class User {
	
	@Id
	@GeneratedValue
	private long id;
	
	@NotNull(message = "{ws.constraints.username.NotNull.message}")
	@Size(min =4, max=255)
	@UniqueUsername
	@JsonView(Views.Base.class)
	private String username;
	
	@NotNull
	@Size(min =4, max=255)
	@JsonView(Views.Base.class)
	private String displayName;
	
	@NotNull
	@Size(min =8, max=255)
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$",message ="{ws.constraints.password.NotNull.Pattern.message}")
	@JsonView(Views.Base.class)
	private String password;
	
	private String image;

	
	

}
