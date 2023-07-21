package com.example.springapp.service;

import com.example.springapp.model.Login;

public interface LoginService {
	
	public Login usercheck(String username);
	
	public Login logincheck(String username , String password);

}