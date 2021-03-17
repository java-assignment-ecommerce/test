package com.cybage.bookings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.cybage.bookings.repository.InventoryRepository;

@SpringBootApplication
public class ECommerceSiteApplication{
	@Autowired
	InventoryRepository inventoryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ECommerceSiteApplication.class, args);
		
	}

}
