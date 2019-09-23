package com.laptrinhjavaweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.exception.ResourceNotFoundException;
import com.laptrinhjavaweb.model.Customer;
import com.laptrinhjavaweb.service.CustomerService;

@Controller
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomers(Model model) {
		System.out.println("customer/list is called");
		List<CustomerDTO> listCustomerDTO = customerService.findAll();
		model.addAttribute("customers", listCustomerDTO);
		return "list-customer";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		Customer theCustomer = new Customer();
		theCustomer.setId(-1);
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}

	@GetMapping("/updateForm/{id}")
	public String showFormForUpdate(@PathVariable("id") int theId, Model model) throws ResourceNotFoundException{
		System.out.println("hello update form");
		System.out.println("id is: " + theId);
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO = customerService.findById(theId);
		model.addAttribute("customer", customerDTO);
		return "customer-form";
	}
	
	
	
	//edit or new
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") CustomerDTO theCustomer) {
		System.out.println("saveCustomer is called");
		theCustomer = customerService.save(theCustomer);
		return "redirect:/customer/list";
	}
	
	//delete
	@GetMapping("/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable("id") int theId,CustomerDTO customerDTO) {
		System.out.println("deleteCustomer is called");
		customerDTO = customerService.deleteById(theId);
		return "redirect:/customer/list";
	}
}
