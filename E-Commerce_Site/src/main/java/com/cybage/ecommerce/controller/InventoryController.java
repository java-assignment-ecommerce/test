package com.cybage.ecommerce.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.cybage.ecommerce.entity.Inventory;
import com.cybage.ecommerce.services.InventoryService;

@RestController
public class InventoryController {

	@Autowired
	InventoryService inventoryService;
	
	@GetMapping("/allInventory")
	public ResponseEntity<List<Inventory>> getAllInventory()
	{
		return ResponseEntity.status(HttpStatus.OK).body(inventoryService.getAllInventory());
		
	}
	

	@GetMapping("/getInventory/{inventoryId}")
	public ResponseEntity<Inventory> getInventoryByid(@PathVariable int inventoryId )
	{
		return ResponseEntity.status(HttpStatus.OK).body(inventoryService.getInventoryById(inventoryId));
		
	}
	
	@PostMapping("/addInventory")
	public ResponseEntity<Inventory> addInventory(@RequestBody Inventory inventory )
	{
		 return ResponseEntity.status(HttpStatus.OK).body(inventoryService.addInventory(inventory));
		
	}
	
	//Update Inventory
	@PutMapping("/updateInventory/{inventoryId}")
	public ResponseEntity<Inventory> updateInventory(@PathVariable int inventoryId,@RequestBody Inventory inventory )
	{
		return ResponseEntity.status(HttpStatus.OK).body(inventoryService.updateInventory(inventoryId,inventory));
		
	}
	
	@DeleteMapping("/deleteInventory/{inventoryId}")
	public ResponseEntity<String> deleteInventoryById(@PathVariable int inventoryId)
	{
		return ResponseEntity.status(HttpStatus.OK).body(inventoryService.deleteInventoryById(inventoryId));
		
	}

	
}
