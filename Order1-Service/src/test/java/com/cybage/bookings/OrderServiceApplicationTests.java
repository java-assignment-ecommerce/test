package com.cybage.bookings;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import com.cybage.bookings.controller.OrderController;

@SpringBootTest
class OrderServiceApplicationTests {


	@Autowired
	OrderController orderController;

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Test
	void contextLoads() {
	}

	@Test
	public void contextLoads_1() throws Exception {
		assertThat(orderController).isNotNull();
	}

}
