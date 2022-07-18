package com.onlinemedicineshop.service;

import java.util.List;
import java.util.Optional;

import com.onlinemedicineshop.entity.Customer;
import com.onlinemedicineshop.security.model.User;

public interface CustomerService {
	
	public List<Customer> getAllCustomers();

	public Optional<Customer> findCustomerById(long id);

	public Customer saveCustomer(Customer customer);

	public void deleteCustomerById(long id);
	
	public Optional<Customer> getCustomerByEmail(String email);
	
	public Optional<User> getCustomerAsUserByEmail(String email);
}
