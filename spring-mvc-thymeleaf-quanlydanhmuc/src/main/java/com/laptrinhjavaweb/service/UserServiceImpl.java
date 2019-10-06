package com.laptrinhjavaweb.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.model.User;
import com.laptrinhjavaweb.repository.UserRepository;

//admin-admin@123
@Service
@Transactional
public class UserServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository ;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Kiểm tra xem user có tồn tại trong database không?
		User user = userRepository.findByUsername(username);

		UserBuilder builder = null;
		if (user != null) {
			// Creates a UserBuilder with a specified user name
			builder = org.springframework.security.core.userdetails.User.withUsername(username);
			builder.disabled(!user.isEnabled());
			builder.password(user.getPassword());
			 String[] authorities = user.getAuthorities()
			          .stream().map(a -> a.getAuthority()).toArray(String[]::new);			 
			 builder.authorities(authorities);
		}else {
		      throw new UsernameNotFoundException("User not found.");
	    }

//		return new CustomUserDetails(user);
		return builder.build();
	}

}
