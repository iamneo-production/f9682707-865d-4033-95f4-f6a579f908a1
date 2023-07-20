package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springapp.model.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {

	Login findByUsername(String username);

	Login findByUsernameAndPassword(String username, String password);

}