package com.laptrinhjavaweb.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.model.Customer;
import com.laptrinhjavaweb.repository.CustomerRepository;

@Service
public class CustomerService {

	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		customerRepository.save(theCustomer);
	}
	
	@Transactional
	public List<Customer> getCustomers(){
		return customerRepository.findAll();
	}
	
	@Transactional
	public Customer getCustomer(int id) {
		return customerRepository.getOne(id);
	}
	
	@Transactional
	public void deleteCustomer(int theId) {
		customerRepository.deleteById(theId);
	}
}
