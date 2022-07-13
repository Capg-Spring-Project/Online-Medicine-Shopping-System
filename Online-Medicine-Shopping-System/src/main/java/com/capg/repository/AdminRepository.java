package com.capg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
