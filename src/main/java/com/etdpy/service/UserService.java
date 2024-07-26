package com.etdpy.service;

import java.util.List;

import com.etdpy.entity.User;

public interface UserService {
	void addUser();
	
	void addUser(User user);
	
	User getStudent(long id);
	
	List<User> getAll();
}