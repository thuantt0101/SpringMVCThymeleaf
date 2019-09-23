package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.CustomerDTO;

public interface CustomerService {

	CustomerDTO save(CustomerDTO customerDTO);
	List<CustomerDTO> findAll();
	CustomerDTO findById(Integer id);
	CustomerDTO  deleteById(Integer id);	
}
 