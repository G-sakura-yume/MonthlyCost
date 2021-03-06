package com.example.demo.login.domain.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class SignupForm {
	@NotBlank
	@Email
	private String userId;
	@NotBlank
	@Length(min=4,max=100)
	@Pattern(regexp="^[a-zA-Z0-9]+$")
	private String password;
}
