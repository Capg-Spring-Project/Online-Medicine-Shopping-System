package com.onlinemedicineshop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.onlinemedicineshop.entity.Customer;
import com.onlinemedicineshop.exception.DuplicateEmailInsertionException;
import com.onlinemedicineshop.repository.CustomerRepository;
import com.onlinemedicineshop.security.model.User;
import com.onlinemedicineshop.service.CustomerService;

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
		customer.setPassword(new BCryptPasswordEncoder().encode(customer.getPassword()));
		try {
			return customerRepository.save(customer);
		} catch (Exception e) {
			throw new DuplicateEmailInsertionException("Email already registered!");
		}
	}

	@Override
	public void deleteCustomerById(long id) {
		customerRepository.deleteById(id);
	}

	@Override
	public Optional<User> getCustomerAsUserByEmail(String email) {
		return customerRepository.getCustomerAsUserByEmail(email);
	}

	@Override
	public Optional<Customer> getCustomerByEmail(String email) {
		return customerRepository.getCustomerByEmail(email);
	}

}
