package com.example.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Login;
import com.example.springapp.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository repo;
	
	@Override
	public void credentials(){
		Login login = new Login();
		login.setUsername("team19");
		login.setPassword("codetitans");
		repo.save(login);
	}
	@Override
	public Login usercheck(String username) {
		Login user = repo.findByUsername(username);
		return user;
	}
	
	@Override
	public Login logincheck(String username, String password) {
		Login user = repo.findByUsernameAndPassword(username, password);
		return user;
	}

}