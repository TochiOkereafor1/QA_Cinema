package com.qa.main.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class BookingModelUnitTests {

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Booking.class).verify();
	}

	@Test
	public void testBookingToString() {
		Booking testBooking = new Booking(1L, "Richard", "Spring", "rspring@gmail.com", 1L, 1, 0, 0);
		String expected = "Booking(bookingId=" + testBooking.getBookingId() + ", forename=" + testBooking.getForename()
				+ ", surname=" + testBooking.getSurname() + ", emailAddress=" + testBooking.getEmailAddress()
				+ ", screeningId=" + testBooking.getScreeningId() + ", adultTickets=" + testBooking.getAdultTickets()
				+ ", childTickets=" + testBooking.getChildTickets() + ", concessionTickets="
				+ testBooking.getConcessionTickets() + ")";
		assertEquals(expected, testBooking.toString());

	}

	@Test
	public void testBookingConstructor1() {
		Booking testBooking = new Booking(1L, "Richard", "Spring", "rspring@gmail.com", 1L, 1, 0, 0);
		assertEquals(Long.valueOf(1), testBooking.getBookingId());
		assertEquals("Richard", testBooking.getForename());
		assertEquals("Spring", testBooking.getSurname());
		assertEquals("rspring@gmail.com", testBooking.getEmailAddress());
		assertEquals(Long.valueOf(1), testBooking.getScreeningId());
		assertEquals(1, testBooking.getAdultTickets());
		assertEquals(0, testBooking.getChildTickets());
		assertEquals(0, testBooking.getConcessionTickets());
	}

	@Test
	public void testBookingConstructor2() {
		Booking testBooking = new Booking("Richard", "Spring", "rspring@gmail.com", 1L, 1, 0, 0);
		assertEquals("Richard", testBooking.getForename());
		assertEquals("Spring", testBooking.getSurname());
		assertEquals("rspring@gmail.com", testBooking.getEmailAddress());
		assertEquals(Long.valueOf(1), testBooking.getScreeningId());
		assertEquals(1, testBooking.getAdultTickets());
		assertEquals(0, testBooking.getChildTickets());
		assertEquals(0, testBooking.getConcessionTickets());
	}

	@Test
	public void testNoArgsBooking() {
	}

	@Test
	public void settersTest() {
		Booking newBooking = new Booking();

		newBooking.setForename("Richard");
		newBooking.setSurname("Spring");
		newBooking.setEmailAddress("rspring@gmail.com");
		newBooking.setScreeningId(1L);
		newBooking.setAdultTickets(1);
		newBooking.setChildTickets(0);
		newBooking.setConcessionTickets(0);

		assertNotNull(newBooking.getForename());
		assertNotNull(newBooking.getSurname());
		assertNotNull(newBooking.getEmailAddress());
		assertNotNull(newBooking.getScreeningId());
		assertNotNull(newBooking.getAdultTickets());
		assertNotNull(newBooking.getChildTickets());
		assertNotNull(newBooking.getConcessionTickets());

		assertEquals(newBooking.getForename(), "Richard");
		assertEquals(newBooking.getSurname(), "Spring");
		assertEquals(newBooking.getEmailAddress(), "rspring@gmail.com");
		assertEquals(newBooking.getScreeningId(), 1L);
		assertEquals(newBooking.getAdultTickets(), 1);
		assertEquals(newBooking.getChildTickets(), 0);
		assertEquals(newBooking.getConcessionTickets(), 0);

	}

}
