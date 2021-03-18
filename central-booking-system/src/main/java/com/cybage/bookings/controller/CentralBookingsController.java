package com.cybage.bookings.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cybage.bookings.dto.Inventory;
import com.cybage.bookings.dto.Order1;
import com.cybage.bookings.dto.OrderDto;

@RestController
@RequestMapping("bookings")
public class CentralBookingsController {

	@Value("${order_url}")
	String orderUrl;
	@Value("${inventory_url}")
	String inventoryUrl;

	private final static String ALL_ORDERS = "/view";
	private final static String ADD = "/add";
	private final static String UPDATE = "/update";
	private final static String DELETE = "/remove";
	private final static String ALL_INVENTORY = "/view";
	@Autowired
	RestTemplate restTemplate;

	@GetMapping
	public String test() {
		return "Central Bookings";
	}

	@GetMapping("orders")
	public ResponseEntity<OrderDto> getOrders() {
		System.out.println("in central booking orders");
		String url = orderUrl + ALL_ORDERS;

		return ResponseEntity.status(HttpStatus.OK).body(getOrderById(url));
	}

	@GetMapping("order/{orderId}")
	public ResponseEntity<OrderDto> getOrder(@PathVariable Integer orderId) {
		System.out.println("in central booking order " + orderId);
		String url = orderUrl;
		url = url + "/" + orderId;
		return ResponseEntity.status(HttpStatus.OK).body(getOrderById(url));
//		return getOrderById(url);
//		return null;
	}

	@GetMapping("inventory/{inventoryId}")
	public ResponseEntity<Inventory> getInventory(@PathVariable Integer inventoryId) {
		System.out.println("in central booking order " + inventoryId);
		String url = inventoryUrl;
		url = url + "/" + inventoryId;
		return ResponseEntity.status(HttpStatus.OK).body(getInventoryById(url));
//		return getInventoryById(url);
//		return null;
	}

	@PostMapping("/inventory")
	public ResponseEntity<?> addInventory(@RequestBody Inventory inventory) throws Exception {
		String url = inventoryUrl;
		url = url + ADD;
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML));

		HttpEntity<String> entity = new HttpEntity<String>(headers);
		Inventory l = restTemplate.postForObject(url, inventory, Inventory.class);
//			ResponseEntity<Order1> l = restTemplate.exchange(url, HttpMethod.POST, entity, Order1.class);
		return ResponseEntity.status(HttpStatus.OK).body(l);
	}

	@PostMapping("/order")
	public ResponseEntity<?> addOrder(@RequestBody Order1 order) throws Exception {
		Integer inventoryId = order.getInventoryId();
		String url = inventoryUrl;
		url = url + "/" + inventoryId;
		Inventory inventory = getInventoryById(url);
//		if (inventory != null) {
		url = orderUrl;
		url = url + ADD;
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML));

		HttpEntity<String> entity = new HttpEntity<String>(headers);
		Order1 l = restTemplate.postForObject(url, order, Order1.class);
//			ResponseEntity<Order1> l = restTemplate.exchange(url, HttpMethod.POST, entity, Order1.class);
		return ResponseEntity.status(HttpStatus.OK).body(l);
//		} else {
////			throw new Exception("Inventory not found");
//			return new ResponseEntity<ErrorMessage>(new ErrorMessage("Inventory not found"), HttpStatus.NOT_FOUND);
//		}
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body)
	}

//	@DeleteMapping("/inventory")
	public ResponseEntity<?> deleteInventory(@PathVariable Integer inventoryId) throws Exception {
		String url = inventoryUrl;
		url = url + DELETE;
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML));

		return null;
	}

	@DeleteMapping("/order")
	public void deleteOrder(@PathVariable Integer orderId) throws Exception {
		String url = orderUrl;
		url = url + DELETE;

		Map<String, Integer> params = new HashMap<>();
		params.put("orderId", orderId);

		restTemplate.delete(url, params);
	}

	private OrderDto getOrderById(String url) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		ResponseEntity<OrderDto> l = restTemplate.exchange(url, HttpMethod.GET, entity, OrderDto.class);
		System.out.println(l);
		return l.getBody();
	}

	private Inventory getInventoryById(String url) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		ResponseEntity<Inventory> l = restTemplate.exchange(url, HttpMethod.GET, entity, Inventory.class);
		System.out.println(l);
		return l.getBody();
	}

}
