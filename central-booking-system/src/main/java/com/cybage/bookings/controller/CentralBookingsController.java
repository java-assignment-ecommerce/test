package com.cybage.bookings.controller;

import java.security.cert.X509Certificate;
import java.util.Arrays;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("bookings")
public class CentralBookingsController {

	@Value("${order_url}")
	String orderUrl;
	@Value("${store_url}")
	String storeUrl;

	@Autowired
	RestTemplate restTemplate;

	
	@GetMapping
	public String test() {
		return "Central Bookings";
	}

	@GetMapping("orders")
	public ResponseEntity<String> getOrders() {
		System.out.println("in central booking orders");
		String url = orderUrl;
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		ResponseEntity<String> l = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		System.out.println(l);
		return ResponseEntity.status(HttpStatus.OK).body(l.getBody());
//		return l;
//		return null;
	}
	
	@GetMapping("orders/{orderId}")
	public ResponseEntity<String> getOrder(@PathVariable Integer orderId) {
		System.out.println("in central booking order "+orderId);
		String url = orderUrl;
		 url=url+"/"+orderId;
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		ResponseEntity<String> l = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		System.out.println(l);
//		l.status(HttpStatus.OK);
//		return l;
		return ResponseEntity.status(HttpStatus.OK).body(l.getBody());
//		return null;
	}
}
