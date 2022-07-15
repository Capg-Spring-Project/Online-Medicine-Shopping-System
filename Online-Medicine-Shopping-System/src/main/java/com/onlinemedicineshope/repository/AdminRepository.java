package com.onlinemedicineshope.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinemedicineshope.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
