package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repo.UserRepo;
import com.example.demo.entity.User;

@Service
public class UserServiceImpl implements UserService{
	
	
	
	@Autowired
	private UserRepo userRepo;
	

	@Override
	public String saveUser(User user) {
	   User userSave= userRepo.save(user);
	   
	  if( userSave!=null) {
		  return "Registration successfull!";
	  }
		return"Invalid credentials";
	}

	@Override
	public User loginCheck(String name, String password) {
		
		return userRepo.findByNameAndPassword(name,password);
		
	}

}
