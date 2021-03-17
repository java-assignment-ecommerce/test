package com.cybage.bookings;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cybage.bookings.entity.Order1;
import com.cybage.bookings.repository.OrderRepository;

@SpringBootApplication
public class OrderServiceApplication implements CommandLineRunner {

	@Autowired
	OrderRepository orderRepository;
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*
		 * Order1 orders = new Order1();
		 * 
		 * orders.setorderId(1);; orders.setInventoryId(2);
		 * orders.setOrderName("Laptop"); orders.setOrderQuantity(3);
		 * orders.setCreateTime(LocalDateTime.now());
		 * orders.setUpdateTime(LocalDateTime.now()); orderRepository.save(orders);
		 */
		 
	}

}
