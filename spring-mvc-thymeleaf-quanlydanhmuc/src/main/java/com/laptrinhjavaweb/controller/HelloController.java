package com.laptrinhjavaweb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.laptrinhjavaweb.dto.RoleDTO;
import com.laptrinhjavaweb.service.RoleService;

@Controller
public class HelloController {

	@Autowired
	private RoleService roleService;

	@GetMapping("/")
	public String index(Model model) {
		List<RoleDTO> listRoleDTO = new ArrayList<>();
		listRoleDTO = roleService.findAll();

		for (RoleDTO roleDTO : listRoleDTO) {
			System.out.println(roleDTO.getRoleName());
			System.out.println(roleDTO.getControllerLink());
		}

		model.addAttribute("roles", listRoleDTO);
		return "index";
	}
}
