package com.onlinemedicineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinemedicineshop.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}