package com.laptrinhjavaweb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.RoleConverter;
import com.laptrinhjavaweb.dto.RoleDTO;
import com.laptrinhjavaweb.model.Role;
import com.laptrinhjavaweb.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private RoleConverter roleConverter;

	@Override
	public List<RoleDTO> findAll() {
		List<RoleDTO> listRoleDTO = new ArrayList<>();
		List<Role> listRole = new ArrayList<>();
		listRole = roleRepository.findAll();

		for (Role role : listRole) {
			RoleDTO roleDTO = new RoleDTO();
			roleDTO = roleConverter.toDTO(role);
			listRoleDTO.add(roleDTO);
		}

		return listRoleDTO;
	}
}
