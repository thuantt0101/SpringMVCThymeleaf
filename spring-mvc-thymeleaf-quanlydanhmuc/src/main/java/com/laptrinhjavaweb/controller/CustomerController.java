package com.laptrinhjavaweb.controller;

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

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.RoleDTO;
import com.laptrinhjavaweb.exception.ResourceNotFoundException;
import com.laptrinhjavaweb.model.Customer;
import com.laptrinhjavaweb.service.CustomerService;
import com.laptrinhjavaweb.service.RoleService;

@Controller
@RequestMapping("customer")
public class CustomerController {
	
	private static final Logger logger = Logger.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerService customerService;

	@Autowired
	private RoleService roleService;

	@GetMapping("/list")
	public String listCustomers(Model model) {
		
		logger.error("This is Error message", new Exception("Testing"));
		
		System.out.println("customer/list is called");
		List<RoleDTO> listRoleDTO = roleService.findAll();
		List<CustomerDTO> listCustomerDTO = customerService.findAll();
		model.addAttribute("customers", listCustomerDTO);
		model.addAttribute("roles", listRoleDTO);
		return "danhmuc/customer/list-customer";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		logger.error("This is Error message", new Exception("Testing"));
		
		Customer theCustomer = new Customer();
		theCustomer.setId(-1);
		theModel.addAttribute("customer", theCustomer);
		return "danhmuc/customer/customer-form";
	}

	//edit
	@GetMapping("/updateForm/{id}")
	public String showFormForUpdate(@PathVariable("id") int theId, Model model) throws ResourceNotFoundException {
		logger.error("This is Error message", new Exception("Testing"));
		System.out.println("hello update form");
		System.out.println("id is: " + theId);
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO = customerService.findById(theId);
		model.addAttribute("customer", customerDTO);
		return "danhmuc/customer/customer-form";
	}

	// edit or new
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") CustomerDTO theCustomer) {
		logger.error("This is Error message", new Exception("Testing"));

		System.out.println("=================================****************===================");
		System.out.println("saveCustomer is called");
		System.out.println(theCustomer.getBirthDay());

		theCustomer = customerService.save(theCustomer);
		return "redirect:/customer/list";
	}

	// delete
	@GetMapping("/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable("id") int theId, CustomerDTO customerDTO) {
		logger.error("This is Error message", new Exception("Testing"));
		System.out.println("deleteCustomer is called");
		customerDTO = customerService.deleteById(theId);
		return "redirect:/customer/list";
	}
	
	@PostMapping("/export")
	public String toListCustomer(@ModelAttribute("customers") CustomerDTO  list ) {
		logger.error("This is Error message", new Exception("Testing"));
						
		System.out.println("export is called");
		return "redirect:/customer/list";
	}
}
