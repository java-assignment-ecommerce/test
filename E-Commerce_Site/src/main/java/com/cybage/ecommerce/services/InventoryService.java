package com.cybage.ecommerce.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.ecommerce.entity.Inventory;
import com.cybage.ecommerce.repository.InventoryRepository;

@Service
public class InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;
	
	//Get List of All inventory items 
	public List<Inventory> getAllInventory() {		
		return inventoryRepository.findAll();
	}
	
	//Search Inventory item by using Id
	public Inventory getInventoryById(int inventoryId) {		
		return inventoryRepository.findById(inventoryId).get();
	}

	//Add item into Inventory
	public Inventory addInventory(Inventory inventory) {	
		return inventoryRepository.save(inventory);
	}

	//Update Inventory item information
	public Inventory updateInventory(int inventoryId,Inventory inventory) {
		Inventory oldInventory=inventoryRepository.findById(inventoryId).get();
		oldInventory.setInventoryName(inventory.getInventoryName());
		oldInventory.setInventoryQuantity(inventory.getInventoryQuantity());
		return inventoryRepository.save(oldInventory);
	}

	//Delete inventory item
	public String deleteInventoryById(int inventoryId) {
		inventoryRepository.deleteById(inventoryId);
		return "deleted successfully";		
	}
	
}
