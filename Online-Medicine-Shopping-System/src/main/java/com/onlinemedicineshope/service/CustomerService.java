package com.onlinemedicineshope.service;

import java.util.List;
import java.util.Optional;

import com.onlinemedicineshope.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getAllCustomers();

	public Optional<Customer> findCustomerById(long id);

	public Customer saveCustomer(Customer customer);

	public void deleteCustomerById(long id);

}
