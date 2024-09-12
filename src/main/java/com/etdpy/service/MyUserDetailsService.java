package com.etdpy.service;

import com.etdpy.dao.MemberRepo;
import com.etdpy.entity.MemberPo;
import com.etdpy.entity.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private MemberRepo memberRepo;

    @Override
    public MyUser loadUserByUsername(String username) 
                  throws UsernameNotFoundException {
        MemberPo memberPo = memberRepo.findByUsername(username);
        if (memberPo == null) {
            throw new BadCredentialsException("帳號或密碼錯誤");
        }else {
        	System.out.println("使用者:"+username+"已登入");
		}
        return new MyUser(memberPo);
}
}