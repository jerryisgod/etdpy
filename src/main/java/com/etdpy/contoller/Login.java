package com.etdpy.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@GetMapping("/index")
	public String helloIndex(){
		return "index";
	}

}