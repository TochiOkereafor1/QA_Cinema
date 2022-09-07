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
import com.qa.main.domain.Ticket;
import com.qa.main.service.TicketService;

@SpringBootTest
@AutoConfigureMockMvc
public class TicketControllerTests {

	@Autowired
	private MockMvc mock;

	@Autowired
	private ObjectMapper mapper;

	@MockBean
	private TicketService service;

	@Autowired
	private ObjectMapper jsonifier;

	@Test
	public void createTicketTest() throws Exception {
		Ticket testTicket = new Ticket(1L, "A1");

		Mockito.when(this.service.createTicket(testTicket)).thenReturn(testTicket);

		this.mock
				.perform(post("/ticket/createTicket").accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON).content(this.jsonifier.writeValueAsString(testTicket)))
				.andExpect(status().isCreated()).andReturn();

	}

}
