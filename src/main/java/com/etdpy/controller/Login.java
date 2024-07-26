package com.etdpy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etdpy.entity.User;
import com.etdpy.service.UserService;

@Controller
public class Login {
	@Autowired
	private UserService service;
	
	@GetMapping("/login")
	public String helloIndex(){
		return "login";
	}
	@GetMapping("/jerry")
	public String helloJerry(){
		return "jerry";
	}
	
	@GetMapping("/add")
	@ResponseBody
	public String addStudent(@RequestParam("userName") String userName,@RequestParam("passWord") String passWord) {
		User user = new User();
		user.setUserName(userName);
		user.setPassWord(passWord);
		service.addUser(user);
		return "ok";
	}


}