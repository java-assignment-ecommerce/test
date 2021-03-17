package com.cybage.bookings.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.bookings.dto.OrderDto;
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

}
