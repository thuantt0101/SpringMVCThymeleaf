package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.RoleDTO;

public interface RoleService {
	List<RoleDTO> findAll();
	List<RoleDTO> findAllByUsername(String username);
}
