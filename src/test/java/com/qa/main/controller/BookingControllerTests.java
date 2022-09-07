package com.qa.main.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.main.domain.Booking;
import com.qa.main.service.BookingService;

@SpringBootTest
@AutoConfigureMockMvc
public class BookingControllerTests {

	@Autowired
	private MockMvc mock;

	@Autowired
	private ObjectMapper mapper;

	@MockBean
	private BookingService service;

	@Autowired
	private ObjectMapper jsonifier;

	@Test
	public void createBookingTest() throws Exception {
		Booking testBooking = new Booking("Andrew", "Slator", "aslator@gmail.com", 1L, 1, 0, 0);

		Mockito.when(this.service.createBooking(testBooking)).thenReturn(testBooking);

		this.mock.perform(post("/booking/createBooking").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(this.jsonifier.writeValueAsString(testBooking)))
				.andExpect(status().isCreated()).andReturn();

	}

}
