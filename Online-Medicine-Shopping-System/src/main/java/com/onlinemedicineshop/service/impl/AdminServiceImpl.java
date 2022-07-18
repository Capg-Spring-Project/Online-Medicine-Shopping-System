package com.onlinemedicineshop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.onlinemedicineshop.entity.Admin;
import com.onlinemedicineshop.repository.AdminRepository;
import com.onlinemedicineshop.security.model.User;
import com.onlinemedicineshop.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminRepository adminRepository;
	
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
		admin.setPassword(new BCryptPasswordEncoder().encode(admin.getPassword()));
		return adminRepository.save(admin);
	}

	@Override
	public void deleteAdminById(long id) {
		adminRepository.deleteById(id);
	}
	
	@Override
	public Optional<User> getAdminAsUserByEmail(String email) {
		return adminRepository.getAdminAsUserByEmail(email);
	}

}
