package com.cybage.bookings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.bookings.entity.Order1;

@Repository
public interface OrderRepository extends JpaRepository<Order1, Integer> {

}
