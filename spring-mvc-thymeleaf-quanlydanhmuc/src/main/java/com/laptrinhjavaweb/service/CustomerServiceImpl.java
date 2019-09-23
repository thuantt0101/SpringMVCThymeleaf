package com.laptrinhjavaweb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.CustomerConverter;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.model.Customer;
import com.laptrinhjavaweb.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerConverter customerConverter;

	@Override
	public CustomerDTO save(CustomerDTO customerDTO) {

		Customer customer = new Customer();
		customer = customerConverter.toEntity(customerDTO);
		customer = customerRepository.save(customer);
		customerDTO = customerConverter.toDTO(customer);
		return customerDTO;

	}

	// works well
	@Override
	public List<CustomerDTO> findAll() {
		List<CustomerDTO> listCustomerDTO = new ArrayList<>();
		List<Customer> listCustomer = new ArrayList<>();

		listCustomer = customerRepository.findAll();

		for (Customer customer : listCustomer) {
			CustomerDTO customerDTO = new CustomerDTO();
			customerDTO = customerConverter.toDTO(customer);
			listCustomerDTO.add(customerDTO);
		}

		return listCustomerDTO;
	}

	@Override
	public CustomerDTO findById(Integer id) {
		CustomerDTO customerDTO = new CustomerDTO();
		Customer customer = new Customer();

		
		customer = customerRepository.getOne(id);

		customerDTO = customerConverter.toDTO(customer);
		return customerDTO;
	}

	@Override
	public CustomerDTO deleteById(Integer id) {
		return null;
	}
}
