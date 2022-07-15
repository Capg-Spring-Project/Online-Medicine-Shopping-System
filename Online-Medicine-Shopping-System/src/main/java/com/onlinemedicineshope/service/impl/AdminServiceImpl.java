package com.onlinemedicineshope.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinemedicineshope.entity.Admin;
import com.onlinemedicineshope.repository.AdminRepository;
import com.onlinemedicineshope.service.AdminService;
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
		return adminRepository.save(admin);
	}

	@Override
	public void deleteAdminById(long id) {
		adminRepository.deleteById(id);
	}

}
