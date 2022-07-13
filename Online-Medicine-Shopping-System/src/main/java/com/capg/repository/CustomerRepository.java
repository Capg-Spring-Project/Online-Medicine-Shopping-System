package com.capg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}