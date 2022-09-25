package com.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.demo.model.User;
import com.project.demo.model.Userdetails;

public interface UsrRepository extends JpaRepository<User, Integer>{
	@Query("select u from User u where u.username=:email")
	  User findbyname(String email);
	
}
