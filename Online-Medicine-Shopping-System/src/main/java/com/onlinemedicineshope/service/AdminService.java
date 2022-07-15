package com.onlinemedicineshope.service;

import java.util.List;
import java.util.Optional;

import com.onlinemedicineshope.entity.Admin;
// new commit
public interface AdminService {
	
	public List<Admin> getAllAdmins();

	public Optional<Admin> findAdminById(long id);

	public Admin saveAdmin(Admin admin);

	public void deleteAdminById(long id);

}
