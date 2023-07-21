package com.example.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Login;
import com.example.springapp.service.LoginService;

@RequestMapping
@RestController
@CrossOrigin
public class LoginController {

	@Autowired
	private LoginService service;

	@PostMapping("/login")
	public String login(@RequestBody Login login) {

		Login UsernameAuth = service.usercheck(login.getUsername());
		Login LoginAuth = service.logincheck(login.getUsername(), login.getPassword());
		if (UsernameAuth != null) {

			if (LoginAuth == null) {

				return "Enter the correct password";
			} else {

				return "Success";
			}

		} else {
			return "User not found";
		}

	}
}