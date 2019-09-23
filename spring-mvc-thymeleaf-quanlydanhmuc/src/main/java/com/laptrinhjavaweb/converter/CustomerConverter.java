package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.model.Customer;

@Component
public class CustomerConverter {

	public Customer toEntity(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		customer.setFirstName(customerDTO.getFirstName());
		customer.setLastName(customerDTO.getLastName());
		customer.setEmail(customerDTO.getEmail());

		return customer;
	}

	public Customer toEntity(Customer customer, CustomerDTO customerDTO) {

		customer.setFirstName(customerDTO.getFirstName());
		customer.setLastName(customerDTO.getLastName());
		customer.setEmail(customerDTO.getEmail());

		return customer;
	}

	public CustomerDTO toDTO(Customer customer) {

		CustomerDTO customerDTO = new CustomerDTO();
		if (customer.getId() != -1) {
			customerDTO.setId(customer.getId());
		}

		customerDTO.setFirstName(customer.getFirstName());
		customerDTO.setLastName(customer.getLastName());
		customerDTO.setEmail(customer.getEmail());

		return customerDTO;
	}
}
