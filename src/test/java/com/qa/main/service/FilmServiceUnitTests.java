package com.qa.main.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.main.domain.Film;
import com.qa.main.repository.FilmRepository;

@SpringBootTest
public class FilmServiceUnitTests {

	@Autowired
	private FilmService service;

	@MockBean
	private FilmRepository repo;

	@Test
	public void createFilmTest() {

		Film savedFilm = new Film("Castaway", 143L, "PG-13");
		Film repoFilm = new Film(1L, "Castaway", 143L, "PG-13");

		Mockito.when(this.service.createFilm(savedFilm)).thenReturn(repoFilm);

		assertEquals(repoFilm, this.service.createFilm(savedFilm));

		Mockito.verify(this.repo, Mockito.times(1)).save(savedFilm);
	}

	@Test
	public void readSingleFilm() {
		Long testId = 1L;
		Film readSingleFilm = new Film("Cast Away", 143L, "PG-13");
		Optional<Film> mockOutputValid = Optional.ofNullable(new Film(1L, "Cast Away", 143L, "PG-13"));
		Film expectedOutput = new Film(1L, "Cast Away", 143L, "PG-13");
		Mockito.when(this.repo.findById(testId)).thenReturn(mockOutputValid);
		assertEquals(expectedOutput, this.service.readSingleFilm(testId));
		Mockito.verify(this.repo, Mockito.times(1)).findById(testId);
	}

	@Test
	public void getAllFilmsTest() {
		Film testFilm1 = new Film(1L, "Castaway", 143L, "PG-13");
		Film testFilm2 = new Film(2L, "Nope", 120L, "15");
		Film testFilm3 = new Film(3L, "Best", 125L, "18");

		List<Film> record = new ArrayList<>();

		Mockito.when(this.service.getAllFilms()).thenReturn(record);

	}

//	@Test
//	public void removeFilmServiceTest() {
//		Film repoFilm = new Film(1L, "Castaway", 143L, "PG-13");
//		Mockito.when(this.service.removeFilm(1L)).thenReturn(false);
//
//	}

//	@Test
//	public void readSingleFilmTest() {
//		Film repoFilm = new Film(1L, "Castaway", 143L, "PG-13");
//
//		Mockito.when(repo.findById(repoFilm.getFilmId())).thenReturn(Optional.of(repoFilm));

}
