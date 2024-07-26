package com.etdpy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Login {

	public static void main(String[] args) {

	}
	
	@GetMapping("/login")
	public String helloIndex(){
		return "login";
	}
	@GetMapping("/jerry")
	public String helloJerry(){
		return "jerry";
	}

}