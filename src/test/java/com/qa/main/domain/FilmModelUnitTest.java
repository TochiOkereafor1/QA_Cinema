package com.qa.main.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class FilmModelUnitTest {

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Film.class).verify();
	}

	@Test
	void testConstructor() {
		Film testFilm = new Film(1L, "Goldeneye", 90L, "15");
		assertThat(testFilm).isNotNull().isInstanceOf(Film.class);
		assertThat(testFilm.getFilmId()).isEqualTo(1L);
		assertThat(testFilm.getTitle()).isEqualTo("Goldeneye");
		assertThat(testFilm.getDuration()).isEqualTo(90L);
		assertThat(testFilm.getRating()).isEqualTo("15");
	}

	@Test
	void testProductionConstructor() {
		Film testFilm = new Film(2L, "Grease", 100L, "12");
		assertThat(testFilm).isNotNull().isInstanceOf(Film.class);
		assertThat(testFilm.getFilmId()).isEqualTo(2L);
		assertThat(testFilm.getTitle()).isEqualTo("Grease");
		assertThat(testFilm.getDuration()).isEqualTo(100L);
		assertThat(testFilm.getRating()).isEqualTo("12");
	}

	@Test
	void testProductionConstructor2() {
		Film testFilm = new Film("Grease", 100L, "12");
		assertThat(testFilm).isNotNull().isInstanceOf(Film.class);
		assertThat(testFilm.getTitle()).isEqualTo("Grease");
		assertThat(testFilm.getDuration()).isEqualTo(100L);
		assertThat(testFilm.getRating()).isEqualTo("12");
	}

	@Test
	void toStringTest() {
		Film testFilm = new Film(3L, "Mamma Mia", 120L, "12");
		String expecting = "Film [filmId=" + testFilm.getFilmId() + ", title=" + testFilm.getTitle() + ", duration="
				+ testFilm.getDuration() + ", rating=" + testFilm.getRating() + "]";
		assertEquals(expecting, testFilm.toString());

	}

	@Test
	public void settersTest() {
		Film newFilm = new Film();

		newFilm.setFilmId(1L);
		newFilm.setTitle("Cast Away");
		newFilm.setDuration(143L);
		newFilm.setRating("PG-13");

		assertNotNull(newFilm.getFilmId());
		assertNotNull(newFilm.getTitle());
		assertNotNull(newFilm.getDuration());
		assertNotNull(newFilm.getRating());

		assertEquals(newFilm.getFilmId(), 1L);
		assertEquals(newFilm.getTitle(), "Cast Away");
		assertEquals(newFilm.getDuration(), 143L);
		assertEquals(newFilm.getRating(), "PG-13");

	}

}