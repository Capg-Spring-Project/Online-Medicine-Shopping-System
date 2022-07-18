package com.onlinemedicineshop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinemedicineshop.entity.Admin;
import com.onlinemedicineshop.security.model.User;


public interface AdminRepository extends JpaRepository<Admin, Long> {
	
	Optional<User> getAdminAsUserByEmail(String email);
	
}
