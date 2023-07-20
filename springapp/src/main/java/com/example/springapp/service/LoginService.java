package com.example.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Login;
import com.example.springapp.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	private LoginRepository repo;

	public Login usercheck(String username) {
		return repo.findByUsername(username);
		
	}

	public Login logincheck(String username, String password) {
		return repo.findByUsernameAndPassword(username, password);
	}

}