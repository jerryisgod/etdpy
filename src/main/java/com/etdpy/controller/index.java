package com.etdpy.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class index {

    @PostMapping("/index")
    public String login(String muid, String mpassword) {
        System.out.println("Username: " + muid + ", Password: " + mpassword);
        if ("jerry".equals(muid) && "a123".equals(mpassword)) {
        	return "index11";
        } else {
        	return "login";
        }
    }
}
