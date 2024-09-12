package com.etdpy.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderUtil {

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * 加密密码
     * 
     * @param rawPassword 原始密码
     * @return 加密后的密码
     */
    public static String encodePassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

  
    public static void main(String[] args) {
        String rawPassword = "a29402884";
        String encodedPassword = encodePassword(rawPassword);
        System.out.println("Encoded Password: " + encodedPassword);
    }
}
