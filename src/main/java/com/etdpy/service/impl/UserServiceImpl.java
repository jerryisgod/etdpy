package com.etdpy.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etdpy.service.UserService;
import com.etdpy.dao.UserDao;
import com.etdpy.entity.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public void addUser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addUser(User user) {
		userDao.save(user);
	}

	@Override
	public User getStudent(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
