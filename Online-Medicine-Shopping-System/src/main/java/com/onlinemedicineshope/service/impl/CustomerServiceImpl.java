package com.onlinemedicineshope.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinemedicineshope.entity.Customer;
import com.onlinemedicineshope.repository.CustomerRepository;
import com.onlinemedicineshope.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService {
	
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Optional<Customer> findCustomerById(long id) {
		return customerRepository.findById(id);
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public void deleteCustomerById(long id) {
		customerRepository.deleteById(id);
	}

}
