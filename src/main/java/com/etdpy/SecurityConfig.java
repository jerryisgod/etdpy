package com.etdpy;

import com.etdpy.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	 @Autowired
	 private MyUserDetailsService myUserDetailsService;


	@Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
        		.csrf(csrf -> csrf.disable())
        		.authenticationManager(authenticationManager())
        		 .formLogin(formLogin -> formLogin
								 .loginPage("/login") // 指定自定義的登入頁面
								 .failureUrl("/login?error=true") // 登入失敗時的重定向
								 .defaultSuccessUrl("/index", true) // 登入成功後重定向到 /home
								 .permitAll() // 允許所有用戶訪問登入頁面
        				 )
                .authorizeHttpRequests(requests -> requests
                	.requestMatchers("/WEB-INF/**").permitAll()
                	.requestMatchers(HttpMethod.GET, "/css/**", "/js/**", "/images/**").permitAll() // 允許靜態資源的請求
                    .requestMatchers(HttpMethod.GET, "/").authenticated()
//                  .requestMatchers(HttpMethod.GET, "/course-feedback").hasAnyRole("USER", "ADMIN")
//                  .requestMatchers(HttpMethod.GET, "/quoteForm").hasRole("管理員")
                    .anyRequest().authenticated()

                )
                .build();
    }
	
	  @Bean
	    public AuthenticationManager authenticationManager() {
	        return new ProviderManager(daoAuthenticationProvider());
	        // 若有多個驗證方式，可使用： 
	        // List.of(daoAuthenticationProvider(), customAuthenticationProvider())
	    }

	    @Bean
	    public DaoAuthenticationProvider daoAuthenticationProvider() {
	        DaoAuthenticationProvider authenticationProvider 
	                                  = new DaoAuthenticationProvider();
	        authenticationProvider.setUserDetailsService(myUserDetailsService);
	        authenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
	        return authenticationProvider;
	    }
	
}
