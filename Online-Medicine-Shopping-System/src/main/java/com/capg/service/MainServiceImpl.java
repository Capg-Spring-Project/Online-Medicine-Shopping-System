package com.capg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Admin;
import com.capg.entity.Category;
import com.capg.entity.Customer;
import com.capg.entity.Medicine;
import com.capg.entity.Order;
import com.capg.repository.AdminRepository;
import com.capg.repository.CategoryRepository;
import com.capg.repository.CustomerRepository;
import com.capg.repository.MedicineRepository;
import com.capg.repository.OrderRepository;

@Service
public class MainServiceImpl implements MainService {
	@Autowired
	AdminRepository adminRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	MedicineRepository medicineRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	OrderRepository orderRepository;

	// Admin Methods
	@Override
	public List<Admin> getAllAdmins() {
		return adminRepository.findAll();
	}

	@Override
	public Optional<Admin> findAdminById(long id) {
		return adminRepository.findById(id);
	}

	@Override
	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	@Override
	public void deleteAdminById(long id) {
		adminRepository.deleteById(id);
	}

	// Customer Methods
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

	// Medicine Methods
	@Override
	public List<Medicine> getAllMedicines() {
		return medicineRepository.findAll();
	}

	@Override
	public Optional<Medicine> findMedicineById(long id) {
		return medicineRepository.findById(id);
	}

	@Override
	public Medicine saveMedicine(Medicine medicine) {
		return medicineRepository.save(medicine);
	}

	@Override
	public void deleteMedicineById(long id) {
		medicineRepository.deleteById(id);
	}

	// Category Methods
	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public Optional<Category> findCategoryById(long id) {
		return categoryRepository.findById(id);
	}

	@Override
	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public void deleteCategoryById(long id) {
		categoryRepository.deleteById(id);
	}

	// Order Methods
	@Override
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public Optional<Order> findOrderById(long id) {
		return orderRepository.findById(id);
	}

	@Override
	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public void deleteOrderById(long id) {
		orderRepository.deleteById(id);
	}

}
