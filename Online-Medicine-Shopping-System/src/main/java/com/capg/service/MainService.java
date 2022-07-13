package com.capg.service;

import java.util.List;
import java.util.Optional;

import com.capg.entity.Admin;
import com.capg.entity.Category;
import com.capg.entity.Customer;
import com.capg.entity.Medicine;
import com.capg.entity.Order;

public interface MainService {
	// Admin Methods
	public List<Admin> getAllAdmins();

	public Optional<Admin> findAdminById(long id);

	public Admin saveAdmin(Admin admin);

	public void deleteAdminById(long id);

	// Customer Methods
	public List<Customer> getAllCustomers();

	public Optional<Customer> findCustomerById(long id);

	public Customer saveCustomer(Customer customer);

	public void deleteCustomerById(long id);

	// Medicine Methods
	public List<Medicine> getAllMedicines();

	public Optional<Medicine> findMedicineById(long id);

	public Medicine saveMedicine(Medicine medicine);

	public void deleteMedicineById(long id);

	// Category Methods
	public List<Category> getAllCategories();

	public Optional<Category> findCategoryById(long id);

	public Category saveCategory(Category category);

	public void deleteCategoryById(long id);

	// Order Methods
	public List<Order> getAllOrders();

	public Optional<Order> findOrderById(long id);

	public Order saveOrder(Order order);

	public void deleteOrderById(long id);
}
