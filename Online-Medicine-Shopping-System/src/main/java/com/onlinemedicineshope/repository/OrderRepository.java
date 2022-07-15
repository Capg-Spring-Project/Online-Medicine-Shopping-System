package com.onlinemedicineshope.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinemedicineshope.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}