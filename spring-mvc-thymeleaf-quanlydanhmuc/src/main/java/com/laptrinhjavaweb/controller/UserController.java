package com.laptrinhjavaweb.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.laptrinhjavaweb.model.User;
import com.laptrinhjavaweb.repository.UserRepository;

@Controller()
@RequestMapping("user")
public class UserController {
	
	private static final Logger logger = Logger.getLogger(UserController.class);

	@Autowired 
	private UserRepository userRepository; 

		
	@GetMapping("/showForm")
	public String createUser(Model model) {			
		logger.error("This is Error message", new Exception("Testing"));		
		User user = new User();		
		model.addAttribute("user", user);		
		return "user/registration";		
	}
	
	// edit or new
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User user,Model model) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));	
		user = userRepository.save(user);
		model.addAttribute("user", user);
		return "redirect:/home";
	}
}
