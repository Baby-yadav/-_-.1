package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	public User findByNameAndPassword(String name ,String password);

}
