package com.cybage.bookings.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cybage.bookings.dto.OrderDto;
import com.cybage.bookings.entity.Order1;
import com.cybage.bookings.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	/**
	 * Get List of All order items
	 */
	public List<Order1> getAllOrders() {

		return orderRepository.findAll();

	}

	/**
	 * Search Order item by using Id
	 */
	public OrderDto getOrderById(Integer orderId) {
		OrderDto orderDto = new OrderDto();

		BeanUtils.copyProperties(orderRepository.findById(orderId).get(), orderDto);

		return orderDto;
	}

	/**
	 * Add item into Order table
	 */
	public Order1 addOrder(Order1 order) {
		return orderRepository.save(order);
	}
	/**
	 * Update Order item information */
	public Order1 updateOrder(int orderId,Order1 order) {
		Order1 oldOrder=orderRepository.findById(orderId).get();
		
		oldOrder.setInventoryId(order.getInventoryId());
		oldOrder.setOrderName(order.getOrderName());
		oldOrder.setOrderQuantity(order.getOrderQuantity());
		oldOrder.setCreateTime(order.getCreateTime());
		oldOrder.setUpdateTime(order.getUpdateTime());
		
		return orderRepository.save(oldOrder);
	}
	/**
	 * Delete order item from table using id*/
	public String deleteOrderById(int orderId) {
		orderRepository.deleteById(orderId);
		return "deleted successfully";		
	}
	
}
