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
		Screening testScreening = new Screening(1L, "13-09-2022", "14:00", 1L);
		assertThat(testScreening).isNotNull().isInstanceOf(Screening.class);
		assertThat(testScreening.getscreeningId()).isEqualTo(1L);
		assertThat(testScreening.getDate()).isEqualTo("13-09-2022");
		assertThat(testScreening.gettime()).isEqualTo("14:00");
		assertThat(testScreening.getfilmId()).isEqualTo(1L);
	}

	@Test
	void testProductionConstructor() {
		Screening testScreening = new Screening("13-09-2022", "14:00", 1L, 120L);
		assertThat(testScreening).isNotNull().isInstanceOf(Screening.class);
		assertThat(testScreening.getDate()).isEqualTo("13-09-2022");
		assertThat(testScreening.gettime()).isEqualTo("14:00");
		assertThat(testScreening.getfilmId()).isEqualTo(1L);
		assertThat(testScreening.getTotal()).isEqualTo(120L);
	}

	@Test
	void testAlArgsConstructor() {
		Screening testScreening = new Screening(1L, "13-09-2022", "14:00", 1L, 120L);
		assertThat(testScreening).isNotNull().isInstanceOf(Screening.class);
		assertThat(testScreening.getscreeningId()).isEqualTo(1L);
		assertThat(testScreening.getDate()).isEqualTo("13-09-2022");
		assertThat(testScreening.gettime()).isEqualTo("14:00");
		assertThat(testScreening.getfilmId()).isEqualTo(1L);
		assertThat(testScreening.getTotal()).isEqualTo(120L);
	}

	@Test
	void toStringTest() {
		Screening testScreening = new Screening(1L, "13-09-2022", "14:00", 1L, 120L);
		String expecting = "Screening [screeningId=" + testScreening.getscreeningId() + ", date="
				+ testScreening.getDate() + ", time=" + testScreening.gettime() + ", filmId="
				+ testScreening.getfilmId() + ", total=" + testScreening.getTotal() + "]";
		assertEquals(expecting, testScreening.toString());

	}

	@Test
	public void settersTest() {
		Screening newScreening = new Screening();

		newScreening.setscreeningId(1L);
		newScreening.setDate("13-09-2022");
		newScreening.settime("10:00");
		newScreening.setfilmId(1L);
		newScreening.setTotal(120L);

		assertNotNull(newScreening.getscreeningId());
		assertNotNull(newScreening.getDate());
		assertNotNull(newScreening.gettime());
		assertNotNull(newScreening.getfilmId());
		assertNotNull(newScreening.getTotal());

		assertEquals(newScreening.getscreeningId(), 1L);
		assertEquals(newScreening.getDate(), "13-09-2022");
		assertEquals(newScreening.gettime(), "10:00");
		assertEquals(newScreening.getfilmId(), 1L);
		assertEquals(newScreening.getTotal(), 120L);

	}

}
