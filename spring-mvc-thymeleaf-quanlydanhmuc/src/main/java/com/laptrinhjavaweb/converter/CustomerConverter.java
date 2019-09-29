package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.model.Customer;
import com.laptrinhjavaweb.util.DateUtil;

@Component
public class CustomerConverter {

	public Customer toEntity(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		if (customerDTO.getId() != -1) {
			customer.setId(customerDTO.getId());
			customer.setCreatedDate(customerDTO.getCreatedDate());
		} else {
			customer.setCreatedDate(DateUtil.getSysdate());
		}

		customer.setFirstName(customerDTO.getFirstName());
		customer.setLastName(customerDTO.getLastName());
		customer.setEmail(customerDTO.getEmail());
		customer.setBirthDay(customerDTO.getBirthDay());

		return customer;
	}

	public Customer toEntity(Customer customer, CustomerDTO customerDTO) {

		customer.setFirstName(customerDTO.getFirstName());
		customer.setLastName(customerDTO.getLastName());
		customer.setEmail(customerDTO.getEmail());
		customer.setCreatedDate(customerDTO.getCreatedDate());
		customer.setBirthDay(customerDTO.getBirthDay());

		return customer;
	}

	public CustomerDTO toDTO(Customer customer) {

		CustomerDTO customerDTO = new CustomerDTO();
		if (customer.getId() != -1) {
			customerDTO.setId(customer.getId());
			customer.setCreatedDate(customer.getCreatedDate());
		}

		customerDTO.setFirstName(customer.getFirstName());
		customerDTO.setLastName(customer.getLastName());
		customerDTO.setEmail(customer.getEmail());
		customerDTO.setBirthDay(customer.getBirthDay());

		return customerDTO;
	}
}
