package com.qa.main.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class ScreeningModelUnitTest {

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Screening.class).verify();
	}

	@Test
	void testConstructor() {
		Screening testScreening = new Screening(1L, "14:00", 1L);
		assertThat(testScreening).isNotNull().isInstanceOf(Screening.class);
		assertThat(testScreening.getfilmId()).isEqualTo(1L);
		assertThat(testScreening.gettime()).isEqualTo("14:00");
		assertThat(testScreening.getscreeningId()).isEqualTo(1L);
	}

	@Test
	void testProductionConstructor() {
		Screening testScreening = new Screening("14:00", 1L);
		assertThat(testScreening).isNotNull().isInstanceOf(Screening.class);
		assertThat(testScreening.gettime()).isEqualTo("14:00");
		assertThat(testScreening.getfilmId()).isEqualTo(1L);
	}

	@Test
	void toStringTest() {
		Screening testScreening = new Screening(1L, "14:00", 1L);
		String expecting = "Screening [screeningId=" + testScreening.getscreeningId() + ", time="
				+ testScreening.gettime() + ", filmId=" + testScreening.getfilmId() + "]";
		assertEquals(expecting, testScreening.toString());

	}

	@Test
	public void settersTest() {
		Screening newScreening = new Screening();

		newScreening.setscreeningId(1L);
		newScreening.settime("10:00");
		newScreening.setfilmId(1L);

		assertNotNull(newScreening.gettime());
		assertNotNull(newScreening.getfilmId());
		assertNotNull(newScreening.getscreeningId());

		assertEquals(newScreening.getscreeningId(), 1L);
		assertEquals(newScreening.gettime(), "10:00");
		assertEquals(newScreening.getfilmId(), 1L);

	}

}
