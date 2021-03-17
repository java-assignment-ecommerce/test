package com.cybage.bookings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.bookings.entity.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer>{

}
