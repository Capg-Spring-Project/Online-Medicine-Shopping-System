package com.onlinemedicineshop.service;

import java.util.List;
import java.util.Optional;

import com.onlinemedicineshop.entity.Admin;
import com.onlinemedicineshop.security.model.User;
// new commit
public interface AdminService {
	
	public List<Admin> getAllAdmins();

	public Optional<Admin> findAdminById(long id);

	public Admin saveAdmin(Admin admin);

	public void deleteAdminById(long id);
	
	public Optional<User> getAdminAsUserByEmail(String email);

}
