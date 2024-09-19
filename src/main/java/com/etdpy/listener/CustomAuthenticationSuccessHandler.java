package com.etdpy.listener;

import com.etdpy.dao.LoginRecordRepo;
import com.etdpy.entity.LoginRecord;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {


    private final LoginRecordRepo loginRecordRepo;



    public CustomAuthenticationSuccessHandler(LoginRecordRepo loginRecordRepo) {
        this.loginRecordRepo = loginRecordRepo;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        System.out.println("Login successful for user: " + authentication.getName());
        String username = authentication.getName();
        LoginRecord loginRecord = new LoginRecord();
        loginRecord.setUsername(username);
        loginRecord.setLoginTime(new Date()); // 使用 java.util.Date 的当前时间
        loginRecordRepo.save(loginRecord);
        response.sendRedirect("/index");

    }
}
