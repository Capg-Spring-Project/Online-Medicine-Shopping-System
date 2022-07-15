package com.onlinemedicineshope.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinemedicineshope.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}