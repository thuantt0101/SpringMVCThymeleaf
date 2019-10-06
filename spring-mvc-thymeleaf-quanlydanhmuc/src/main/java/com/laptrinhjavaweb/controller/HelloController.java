package com.laptrinhjavaweb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.laptrinhjavaweb.dto.RoleDTO;
import com.laptrinhjavaweb.service.RoleService;

@Controller
public class HelloController {

	@Autowired
	private RoleService roleService;

	@GetMapping({"/","/hello"})
	public String index(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loginUsername = auth.getName();
		
		List<RoleDTO> listRoleDTO = new ArrayList<>();
		listRoleDTO = roleService.findAllByUsername(loginUsername);

		for (RoleDTO roleDTO : listRoleDTO) {
			System.out.println(roleDTO.getRoleName());
			System.out.println(roleDTO.getControllerLink());
		}

		model.addAttribute("roles", listRoleDTO);
		return "index";
	}
	
}
