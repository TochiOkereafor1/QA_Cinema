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
import com.qa.main.domain.Film;
import com.qa.main.service.FilmService;

@SpringBootTest
@AutoConfigureMockMvc
public class FilmControllerTests {

	@Autowired
	private MockMvc mock;

	@Autowired
	private ObjectMapper mapper;

	@MockBean
	private FilmService service;

	@Autowired
	private ObjectMapper jsonifier;

	@Test
	public void createFilmTest() throws Exception {
		Film testFilm = new Film("Cast Away", 140L, "PG_13");

		Mockito.when(this.service.createFilm(testFilm)).thenReturn(testFilm);

		this.mock
				.perform(post("/film/createFilm").accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON).content(this.jsonifier.writeValueAsString(testFilm)))
				.andExpect(status().isCreated()).andReturn();

	}
}
