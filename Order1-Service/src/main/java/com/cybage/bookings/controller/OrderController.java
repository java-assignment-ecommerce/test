package com.cybage.bookings.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cybage.bookings.dto.OrderDto;
import com.cybage.bookings.entity.Order1;
import com.cybage.bookings.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	OrderService orderService;

	@Autowired
	ModelMapper modelMapper;

	/**
	 * This will return a list of ORDERS
	 */
	@GetMapping("/view")
	@ResponseBody
	public ResponseEntity<List<OrderDto>> getAllOrders() {
		return ResponseEntity.status(HttpStatus.OK)
				.body(orderService.getAllOrders().stream()
				.map(o -> modelMapper.map(o, OrderDto.class))
				.collect(Collectors.toList()));
	}

	/**
	 * This will return particular inventory using id
	 */
	@GetMapping("/{orderId}")
	public ResponseEntity<OrderDto> getOrderByid(@PathVariable int orderId) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(orderService.getOrderById(orderId));
	}

	/**
	 *This will a single order record into table*/
	@PostMapping("/add")
	public ResponseEntity<Order1> addInventory(@RequestBody Order1 order )
	{
		 return ResponseEntity.status(HttpStatus.OK).body(orderService.addOrder(order));
		
	}
	/**
	 *This will update single record using id */
	@PutMapping("/update/{orderId}")
	public ResponseEntity<Order1> updateOrder(@PathVariable int orderId,@RequestBody Order1 order )
	{
		return ResponseEntity.status(HttpStatus.OK).body(orderService.updateOrder(orderId,order));
		
	}
	/**
	 * This will delete single record of order from table
	 * If any dependency is there then stop/revert this operation*/
	
	@DeleteMapping("/remove/{orderId}")
	public ResponseEntity<String> deleteInventoryById(@PathVariable int orderId)
	{
		return ResponseEntity.status(HttpStatus.OK).body(orderService.deleteOrderById(orderId));
		
	}

}
