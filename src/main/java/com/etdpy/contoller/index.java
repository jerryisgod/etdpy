package com.etdpy.contoller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class index {

    @PostMapping("/index")
    public String login(String muid, String mpassword) {
        System.out.println("Username: " + muid + ", Password: " + mpassword);
        if ("jerry".equals(muid) && "a123".equals(mpassword)) {
        	return "index";
        } else {
        	return "login";
        }
    }
}
