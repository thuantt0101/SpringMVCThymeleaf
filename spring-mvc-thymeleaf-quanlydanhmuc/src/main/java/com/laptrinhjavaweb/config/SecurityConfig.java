package com.laptrinhjavaweb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//references:  https://docs.spring.io/spring-security/site/docs/current/guides/html5/hellomvc-javaconfig.html
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//	The SecurityConfig will:
//	Require authentication to every URL in your application
//	Generate a login form for you
//	Allow the user with the Username user and the Password password to authenticate with form based authentication
//	Allow the user to logout
//	CSRF attack prevention
//	Session Fixation protection
//	Security Header integration
//	HTTP Strict Transport Security for secure requests
//
//	1. X-Content-Type-Options integration
//
//	2. Cache Control (can be overridden later by your application to allow caching of your static resources)
//
//	3. X-XSS-Protection integration
//
//	4. X-Frame-Options integration to help prevent Clickjacking
//	Integrate with the following Servlet API methods
//
//	1. HttpServletRequest#getRemoteUser()
//
//	2. HttpServletRequest.html#getUserPrincipal()
//
//	3. HttpServletRequest.html#isUserInRole(java.lang.String)
//
//	4. HttpServletRequest.html#login(java.lang.String, java.lang.String)
//
//	5. HttpServletRequest.html#logout()
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		// Password encoder, để Spring Security sử dụng mã hóa mật khẩu người dùng
		return new BCryptPasswordEncoder();
	}

	// solution to fix There is no PasswordEncoder mapped for the id "null"
	// https://www.mkyong.com/spring-boot/spring-security-there-is-no-passwordencoder-mapped-for-the-id-null/
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		/**
//		 * Doan ben duoi dung de login su dung username va password thuong
//		 */
////		auth.inMemoryAuthentication().withUser("thanhthuan").password("{noop}password").roles("USER").and().withUser("admin")
////				.password("{noop}password").roles("ADMIN");
//
//		/**
//		 * Doan ben duoi dung de login su dung username va password dua tren hibernate
//		 * jpa
//		 */
//		auth.userDetailsService(userService)// Cung cáp userservice cho spring security
//				.passwordEncoder(passwordEncoder());// cung cấp password encoder
//	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService) // Cung cáp userservice cho spring security
				.passwordEncoder(passwordEncoder()); // cung cấp password encoder
	}

	//https://docs.spring.io/spring-security/site/docs/current/guides/html5/form-javaconfig.html
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/resources/**").permitAll()//allow everyone to access our resources and our logout pages
				.anyRequest().authenticated()
				.anyRequest().hasAnyRole("ADMIN", "USER")//				
				.and()
				.formLogin()// form based authentication is supported 
				.loginPage("/login") //when authentication is required, redirect the browser to /Login.We are in charge of rendering the login page when /login is requested
				.permitAll()		
				.defaultSuccessUrl("/hello")//
				.and().logout().logoutSuccessUrl("/login").permitAll();								
	}

}
