package com.qa.main.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.main.domain.Booking;
import com.qa.main.repository.BookingRepository;

@SpringBootTest
public class BookingServiceUnitTests {

	@Autowired
	private BookingService service;

	@MockBean
	private BookingRepository repo;

	@Test
	public void createBookingTest() {

		Booking savedBooking = new Booking("Andrew", "Slator", "aslator@gmail.com", 1L);
		Booking repoBooking = new Booking(1L, "Andrew", "Slator", "aslator@gmail.com", 1L);

		Mockito.when(this.service.createBooking(savedBooking)).thenReturn(repoBooking);

		assertEquals(repoBooking, this.service.createBooking(savedBooking));

		Mockito.verify(this.repo, Mockito.times(1)).save(savedBooking);
	}

	@Test
	public void testGetById() {
		Long testId = 1L;
		Booking readBooking = new Booking("Andrew", "Slator", "aslator@gmail.com", 1L);
		Optional<Booking> mockOutputValid = Optional
				.ofNullable(new Booking(1L, "Andrew", "Slator", "aslator@gmail.com", 1L));
		Booking expectedOutput = new Booking(1L, "Andrew", "Slator", "aslator@gmail.com", 1L);
		Mockito.when(this.repo.findById(testId)).thenReturn(mockOutputValid);
		assertEquals(expectedOutput, this.service.readBooking(testId));
		Mockito.verify(this.repo, Mockito.times(1)).findById(testId);
	}

//	@Test
//	public void testUpdate() {
//		Long testId = 1L;
//		Booking updateBooking = new Booking("Andrew", "Slator", "aslator@gmail.com", 1L);
//		Optional<Booking> mockOutputValid = Optional
//				.ofNullable(new Booking(1L, "Andrew", "Pimlott", "pimlott@gmail.com", 2L));
//		Booking expectedOutput = new Booking(1L, "Andrew", "Pimlott", "apimlottr@gmail.com", 2L);
//		Mockito.when(this.repo.findById(testId)).thenReturn(mockOutputValid);
//		Mockito.when(this.repo.save(expectedOutput)).thenReturn(expectedOutput);
//		assertEquals(expectedOutput, this.service.updateBooking(expectedOutput, testId));
//		Mockito.verify(this.repo, Mockito.times(1)).save(expectedOutput);
//		Mockito.verify(this.repo, Mockito.times(1)).findById(testId);
//	}

	@Test
	public void testDelete() {
		Booking deleteBooking = new Booking(1L, "Andrew", "Slator", "aslator@gmail.com", 1L);

		Mockito.when(this.repo.findById(deleteBooking.getBookingId())).thenReturn(Optional.of(deleteBooking));
		this.service.deleteBooking(deleteBooking.getBookingId());
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(deleteBooking.getBookingId());
	}

}
