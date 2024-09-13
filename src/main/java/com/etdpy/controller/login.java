package com.etdpy.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class login {
	@GetMapping("/login")
	public String index() {
		return "login";
	}

	@GetMapping("/index")
	public String home01(){
		return "index";
	}

	@GetMapping("/ok")
	@ResponseBody
	public String OK(){
		return "OK";
	}

	@GetMapping("/no")
	@ResponseBody
	public String NO(){
		return "NO";
	}
}