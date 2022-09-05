package com.qa.main.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class ScreeningModelUnitTest {
	
	private static Screening testScreening; 
	
	@Test
	void testConstructor() {
		testScreening = new Screening(1L, "14:00", 1L);
		assertThat(testScreening).isNotNull().isInstanceOf(Screening.class);
		assertThat(testScreening.getfilmId()).isEqualTo(1L); 
		assertThat(testScreening.gettime()).isEqualTo("14:00"); 
		assertThat(testScreening.getscreeningId()).isEqualTo(1L); 
	}
	
	@Test
	void testProductionConstructor() {
		testScreening = new Screening("14:00", 1L);
		assertThat(testScreening).isNotNull().isInstanceOf(Screening.class);
		assertThat(testScreening.gettime()).isEqualTo("14:00");
		assertThat(testScreening.getfilmId()).isEqualTo(1L); 		
	}
	
	@Test
	void toStringTest() {
		testScreening = new Screening(1L, "14:00", 1L);
		String expecting = "Screening [id=" + testScreening.getscreeningId() + ", time=" + testScreening.gettime() + ", filmId=" + testScreening.getfilmId() + "]";
		assertEquals(expecting, testScreening.toString());
	
	}
	

}
