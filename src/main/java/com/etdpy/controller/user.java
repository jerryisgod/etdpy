package com.etdpy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etdpy.entity.User;
import com.etdpy.service.UserService;

@RestController
@RequestMapping("/user")
public class user {
	@Autowired
	private UserService service;
	
	@GetMapping("/add")
	public String addStudent(@RequestParam("userName") String userName,@RequestParam("passWord") String passWord) {
		User user = new User();
		user.setUserName(userName);
		user.setPassWord(passWord);
		
		service.addUser(user);
		
		List<User> list = service.getAll();
		
		return list.get(list.size()-1).toString();
	}

}
