package com.cybage.ecommerce;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.cybage.ecommerce.entity.Inventory;
import com.cybage.ecommerce.repository.InventoryRepository;

@SpringBootApplication
public class ECommerceSiteApplication implements CommandLineRunner{
	@Autowired
	InventoryRepository inventoryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ECommerceSiteApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
//		Inventory inventory = new Inventory();
//		
//		inventory.setInventoryName("Computer");
//		inventory.setInventoryQuantity(10);
//		inventory.setcreateTime(LocalDateTime.now());
//		inventory.setUpdateTime(LocalDateTime.now());
//		
//		inventoryRepository.save(inventory);
		
	}

}
