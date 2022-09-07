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
import com.qa.main.domain.Screening;
import com.qa.main.service.ScreeningService;

@SpringBootTest
@AutoConfigureMockMvc
public class ScreeningControllerTests {

	@Autowired
	private MockMvc mock;

	@Autowired
	private ObjectMapper mapper;

	@MockBean
	private ScreeningService service;

	@Autowired
	private ObjectMapper jsonifier;

	@Test
	public void createScreeningTest() throws Exception {
		Screening testScreening = new Screening("10:00", 1L);

		Mockito.when(this.service.createScreening(testScreening)).thenReturn(testScreening);

		this.mock.perform(post("/screening/createScreening").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(this.jsonifier.writeValueAsString(testScreening)))
				.andExpect(status().isCreated()).andReturn();

	}

}
