package com.capg.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Admin;
import com.capg.repository.AdminRepository;
import com.capg.service.AdminService;
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
