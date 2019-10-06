package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.model.User;

//Mặc định Spring Security sử dụng một đối tượng UserDetails để chứa toàn bộ thông tin về người dùng. 
//Vì vậy, chúng ta cần tạo ra một class mới giúp chuyển các thông tin của User thành UserDetails
public interface UserRepository extends JpaRepository<User, String>{
	User findByUsername(String username);
}
