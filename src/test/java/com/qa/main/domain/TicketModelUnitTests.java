package com.qa.main.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class TicketModelUnitTests {

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Ticket.class).verify();
	}

	@Test
	public void testTicketToString() {
		Ticket testTicket = new Ticket(1L, 1L, "A1");
		String expected = "Ticket [ticketId=" + testTicket.getTicketId() + ", bookingId=" + testTicket.getBookingId()
				+ ", seatRef=" + testTicket.getSeatRef() + "]";
		assertEquals(expected, testTicket.toString());

	}

	@Test
	public void testTicketConstructor1() {
		Ticket testTicket = new Ticket(1L, 1L, "A1");
		assertEquals(Long.valueOf(1), testTicket.getTicketId());
		assertEquals(Long.valueOf(1), testTicket.getBookingId());
		assertEquals("A1", testTicket.getSeatRef());

	}

	@Test
	public void testTicketConstructor2() {
		Ticket testTicket = new Ticket(1L, "A1");
		assertEquals(Long.valueOf(1), testTicket.getBookingId());
		assertEquals("A1", testTicket.getSeatRef());
	}

	@Test
	public void testTicketConstructorWithTasks() {
	}

	@Test
	public void settersTest() {
		Ticket newTicket = new Ticket();

		newTicket.setBookingId(1L);
		newTicket.setSeatRef("A1");

		assertNotNull(newTicket.getBookingId());
		assertNotNull(newTicket.getSeatRef());

		assertEquals(newTicket.getBookingId(), 1L);
		assertEquals(newTicket.getSeatRef(), "A1");

	}

}
