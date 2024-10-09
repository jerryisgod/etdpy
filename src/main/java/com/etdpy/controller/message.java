package com.etdpy.controller;
import com.etdpy.entity.LoginRecord;
import com.etdpy.service.CustomerService;
import com.etdpy.service.LoginRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;


@Controller
public class message {
	private static final Logger logger
			= LoggerFactory.getLogger(message.class);

	@GetMapping("/SaveCustomerSuccess")
	public String showSuccessPage1() { //新增成功
		return "saveSuccess";
	}
	@GetMapping("/saveSuccess1")
	public String showSuccessPage2() { //修改成功
		return "saveSuccess1";
	}
	@GetMapping("/saveSuccess2")
	public String showSuccessPage4() { //刪除成功
		return "saveSuccess2";
	}
	@GetMapping("/maintenance")
	public String showSuccessPage3() { //維修中
		return "maintenance";
	}

}