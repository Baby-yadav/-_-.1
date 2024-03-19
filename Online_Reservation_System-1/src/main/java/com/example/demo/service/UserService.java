package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService  {
	
	public String saveUser(User res);
	public User loginCheck(String name ,String password);  

	
}