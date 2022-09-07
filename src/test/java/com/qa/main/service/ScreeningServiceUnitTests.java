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

import com.qa.main.domain.Screening;
import com.qa.main.repository.ScreeningRepository;

@SpringBootTest
public class ScreeningServiceUnitTests {

	@Autowired
	private ScreeningService service;

	@MockBean
	private ScreeningRepository repo;

	@Test
	public void createScreeningTest() {

		Screening savedScreening = new Screening("13-09-2022", "10:00", 1L, 120L);
		Screening repoScreening = new Screening(1L, "13-09-2022", "10:00", 1L, 120L);

		Mockito.when(this.service.createScreening(savedScreening)).thenReturn(repoScreening);

		assertEquals(repoScreening, this.service.createScreening(savedScreening));

		Mockito.verify(this.repo, Mockito.times(1)).save(savedScreening);
	}

	@Test
	public void readSingleScreening() {
		Long testId = 1L;
		Screening readSingleScreening = new Screening("13-09-2022", "10:00", 1L, 120L);
		Optional<Screening> mockOutputValid = Optional.ofNullable(new Screening(1L, "13-09-2022", "10:00", 1L, 120L));
		Screening expectedOutput = new Screening(1L, "13-09-2022", "10:00", 1L, 120L);
		Mockito.when(this.repo.findById(testId)).thenReturn(mockOutputValid);
		assertEquals(expectedOutput, this.service.readSingleScreening(testId));
		Mockito.verify(this.repo, Mockito.times(1)).findById(testId);
	}

	@Test
	public void getAllScreeningsTest() {
		Screening testScreening1 = new Screening(1L, "13-09-2022", "10:00", 1L, 120L);
		Screening testScreening2 = new Screening(2L, "13-09-2022", "13:00", 3L, 120L);
		Screening testScreening3 = new Screening(3L, "13-09-2022", "15:00", 2L, 120L);

		List<Screening> record = new ArrayList<>();

		Mockito.when(this.service.getAllScreenings()).thenReturn(record);

	}
}
