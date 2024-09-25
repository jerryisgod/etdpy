package com.etdpy.controller;
import com.etdpy.entity.LoginRecord;
import com.etdpy.service.LoginRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.List;


@Controller
public class login {
	@Autowired
	private LoginRecordService loginRecordService;


	private static final Logger logger
			= LoggerFactory.getLogger(login.class);

	@GetMapping("/login")
	public String index() {
		return "login";
	}

	@GetMapping("/index")
	public String home01(Model model, Principal principal) {
		String username = principal.getName();
		List<LoginRecord> loginRecords = loginRecordService.getRecentLoginRecords(username);
		model.addAttribute("loginRecords", loginRecords);
		return "index";
	}

	@GetMapping("/quoteForm")
	public String quoteForm() {
		return "quoteForm";
	}
	@GetMapping("/eeee")
	public String eee() {
		return "eeee";
	}
}