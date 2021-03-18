package com.cybage.bookings.utils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.cybage.bookings.dto.OrderDto;
import com.cybage.bookings.entity.Order1;

public class OrderTestData {

	public OrderTestData() {
	}

	
	public static Order1 createOrder1_1() {
		Order1 s1 = new Order1();
		s1.setCreateTime(LocalDateTime.now());
		s1.setorderId(1);
		s1.setOrderName("Order1 1");
		s1.setOrderQuantity(12);
		return s1;
	}

	public static Order1 createOrder1_2() {
		Order1 s1 = new Order1();
		s1.setCreateTime(LocalDateTime.now());
		s1.setorderId(2);
		s1.setOrderName("Order1 2");
		s1.setOrderQuantity(22);
		return s1;
	}

	public static List<Order1> createOrder1s2Records() {
		List<Order1> Order1s = new ArrayList<>();
		Order1s.add(createOrder1_1());
		Order1s.add(createOrder1_2());
		return Order1s;
	}
	public static OrderDto createOrderDto_1() {
		OrderDto s1 = new OrderDto();
		s1.setCreateTime(LocalDateTime.now());
		s1.setOrderId(1);
		s1.setOrderName("Order1 1");
		s1.setOrderQuantity(12);
		return s1;
	}

	public static OrderDto createOrderDto_2() {
		OrderDto s1 = new OrderDto();
		s1.setCreateTime(LocalDateTime.now());
		s1.setOrderId(2);
		s1.setOrderName("Order1 2");
		s1.setOrderQuantity(22);
		return s1;
	}

	public static List<OrderDto> createOrder1sDTOSingleEntry() {
		List<OrderDto> Order1s = new ArrayList<>();
		Order1s.add(createOrderDto_1());
		return Order1s;
	}

	public static List<OrderDto> createOrder1sDTO2Records() {
		List<OrderDto> Order1s = new ArrayList<>();
		Order1s.add(createOrderDto_1());
		Order1s.add(createOrderDto_2());
		return Order1s;
	}

}