package com.cybage.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.ecommerce.entity.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer>{

}
