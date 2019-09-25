package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.RoleDTO;
import com.laptrinhjavaweb.model.Role;

@Component
public class RoleConverter {

	public Role toEntity(RoleDTO roleDTO) {

		Role role = new Role();

		if (roleDTO.getId() != -1) {
			role.setId(roleDTO.getId());
		}

		role.setRoleName(roleDTO.getRoleName());
		role.setParentRoleId(roleDTO.getParentRoleId());
		role.setEnabled(roleDTO.getEnabled());
		role.setControllerLink(roleDTO.getControllerLink());
		return role;
	}

	public RoleDTO toDTO(Role role) {

		RoleDTO roleDTO = new RoleDTO();
		roleDTO.setId(role.getId());
		roleDTO.setRoleName(role.getRoleName());
		roleDTO.setParentRoleId(role.getParentRoleId());
		roleDTO.setEnabled(role.getEnabled());
		roleDTO.setControllerLink(role.getControllerLink());

		return roleDTO;
	}

	public Role toEntity(Role role, RoleDTO roleDTO) {

		role.setRoleName(roleDTO.getRoleName());
		role.setParentRoleId(roleDTO.getParentRoleId());
		role.setEnabled(roleDTO.getEnabled());
		role.setControllerLink(roleDTO.getControllerLink());

		return role;
	}

}
