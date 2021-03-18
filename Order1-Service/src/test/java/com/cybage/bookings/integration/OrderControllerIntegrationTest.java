package com.cybage.bookings.integration;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.cybage.bookings.OrderServiceApplication;
import com.cybage.bookings.entity.Order1;
import com.cybage.bookings.repository.OrderRepository;

@RunWith(SpringRunner.class)

//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = OrderServiceApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
public class OrderControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private OrderRepository repository;

	private static final String STORE_URL = "/order";

//	@LocalServerPort
//	private int port;

	@Before
	public void setup() {
//		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testgetOrders() throws Exception {

		createStore("Test Books1", 11);
		createStore("Test Books2", 22);

		mockMvc.perform(get(STORE_URL).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(jsonPath("$.storeDtos", hasSize(2)))
				.andExpect(jsonPath("$.storeDtos[0].orderName", is("Test Books1")))
				.andExpect(jsonPath("$.storeDtos[0].orderQuantity", is(11)))
				.andExpect(jsonPath("$.storeDtos[1].orderName", is("Test Books2")))
				.andExpect(jsonPath("$.storeDtos[1].orderQuantity", is(22))).andExpect(status().isOk());
	}

	private void createStore(String storeName, Integer storeQuantity) {

		Order1 s = new Order1();
		s.setOrderName(storeName);
		s.setOrderQuantity(storeQuantity);
		repository.save(s);

	}
}
