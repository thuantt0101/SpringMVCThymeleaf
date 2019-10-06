package com.laptrinhjavaweb.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.laptrinhjavaweb.dto.DmNhVtDTO;
import com.laptrinhjavaweb.dto.DmVtDTO;
import com.laptrinhjavaweb.dto.RoleDTO;
import com.laptrinhjavaweb.service.DmNhVtService;
import com.laptrinhjavaweb.service.DmVtService;
import com.laptrinhjavaweb.service.RoleService;

@Controller
@RequestMapping("dmvt")
public class DmVtController {
	
	private static final Logger logger = Logger.getLogger(DmVtController.class);

	@Autowired
	private DmVtService dmVtService;

	@Autowired
	private DmNhVtService dmNhVtService;

	@Autowired
	private RoleService roleService;

	@GetMapping("/list")
	public String listDmVts(Model model) {
		logger.error("This is Error message", new Exception("Testing"));
		
		System.out.println("findAll list of dmvt is called");
		List<DmVtDTO> listDTO = new ArrayList<>();

		List<RoleDTO> listRoleDTO = roleService.findAll();

		listDTO = dmVtService.findAll();

		for (DmVtDTO dmvtDTO : listDTO) {
			System.out.println(dmvtDTO.getMaVt());
			System.out.println(dmvtDTO.getTenVt());
			System.out.println(dmvtDTO.getMaNhVtId());
		}
		model.addAttribute("dmvts", listDTO);
		model.addAttribute("roles", listRoleDTO);
		return "/danhmuc/dmvt/dmvt-list";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		logger.error("This is Error message", new Exception("Testing"));
		DmVtDTO dmvtDTo = new DmVtDTO();
		dmvtDTo.setId(-1);		
		theModel.addAttribute("dmvt", dmvtDTo);
		
		List<DmNhVtDTO> listNhVtDTO = dmNhVtService.findAll();
		theModel.addAttribute("dmnhvts", listNhVtDTO);
		return "/danhmuc/dmvt/dmvt-form";
	}

	// delete
	@GetMapping("/delete/{id}")
	public String deleteDmVt(@PathVariable("dmvt") DmVtDTO dmvtDTO) {
		logger.error("This is Error message", new Exception("Testing"));
		dmvtDTO = dmVtService.deleteById(dmvtDTO.getId());
		return "redirect: /dmvt/list";
	}

	@PostMapping("/saveDmVt")
	public String save(@ModelAttribute("dmvt") DmVtDTO dmvtDTO) {
		logger.error("This is Error message", new Exception("Testing"));
		System.out.println("save dmvt is called");
		System.out.println(dmvtDTO.getMaNhVtId());
		dmvtDTO = dmVtService.save(dmvtDTO);
		return "redirect:/dmvt/list";
	}

	@GetMapping("/updateForm/{id}")
	public String updateForm(@PathVariable("id") int theID, Model theModel) {
		logger.error("This is Error message", new Exception("Testing"));
		DmVtDTO dmvtDTO = new DmVtDTO();
		dmvtDTO = dmVtService.findById(theID);
		dmvtDTO = dmVtService.save(dmvtDTO);
		theModel.addAttribute("dmvt", dmvtDTO);
		List<DmNhVtDTO> listDmNhVtDTO = new ArrayList<>();
		listDmNhVtDTO = dmNhVtService.findAll();
		theModel.addAttribute("dmnhvts", listDmNhVtDTO);
		return "/danhmuc/dmvt/dmvt-form";
	}

}
