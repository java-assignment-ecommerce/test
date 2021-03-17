package com.cybage.bookings.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.cybage.bookings.entity.Inventory;
import com.cybage.bookings.services.InventoryService;

@RestController
@RequestMapping("lnventory")
public class InventoryController {

	@Autowired
	InventoryService inventoryService;
	/**
	 *  This will return a list of inventory*/
	@GetMapping("/view")
	public ResponseEntity<List<Inventory>> getAllInventory()
	{
		return ResponseEntity.status(HttpStatus.OK).body(inventoryService.getAllInventory());
		
	}
	
	/** 
	 * This will return particular inventory using id*/
	@GetMapping("/{inventoryId}")
	public ResponseEntity<Inventory> getInventoryByid(@PathVariable int inventoryId )
	{
		return ResponseEntity.status(HttpStatus.OK).body(inventoryService.getInventoryById(inventoryId));
		
	}
	/**
	 *This will insert single inventory record into table*/
	@PostMapping("/add")
	public ResponseEntity<Inventory> addInventory(@RequestBody Inventory inventory )
	{
		 return ResponseEntity.status(HttpStatus.OK).body(inventoryService.addInventory(inventory));
		
	}
	
	/**
	 *This will update single record using id */
	@PutMapping("/update/{inventoryId}")
	public ResponseEntity<Inventory> updateInventory(@PathVariable int inventoryId,@RequestBody Inventory inventory )
	{
		return ResponseEntity.status(HttpStatus.OK).body(inventoryService.updateInventory(inventoryId,inventory));
		
	}
	/**
	 * This will delete single record of inventory from table
	 * If any dependency is there then stop/revert this operation*/
	@DeleteMapping("/remove/{inventoryId}")
	public ResponseEntity<String> deleteInventoryById(@PathVariable int inventoryId)
	{
		return ResponseEntity.status(HttpStatus.OK).body(inventoryService.deleteInventoryById(inventoryId));
		
	}

	
}
