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

import com.qa.main.domain.Ticket;
import com.qa.main.repository.TicketRepository;

@SpringBootTest
public class TicketServiceUnitTests {

	@Autowired
	private TicketService service;

	@MockBean
	private TicketRepository repo;

	@Test
	public void createTicketTest() {
		Ticket savedTicket = new Ticket(1L, "A1");
		Ticket repoTicket = new Ticket(1L, 1L, "A1");

		Mockito.when(this.service.createTicket(savedTicket)).thenReturn(repoTicket);

		assertEquals(repoTicket, this.service.createTicket(savedTicket));

		Mockito.verify(this.repo, Mockito.times(1)).save(savedTicket);

	}

	@Test
	public void getAllTicketsTest() {
		Ticket testTicket1 = new Ticket(1L, 1L, "A1");
		Ticket testTicket2 = new Ticket(2L, 3L, "B1");
		Ticket testTicket3 = new Ticket(3L, 2L, "D4");

		List<Ticket> record = new ArrayList<>();

		Mockito.when(this.service.readAllTickets()).thenReturn(record);

	}

//	@Test
//	public void readSingleTicket() {
//		Long testId = 1L;
//		Ticket readTicketByBookingId = new Ticket(1L, "A1");
//		Optional<Ticket> mockOutputValid = Optional.ofNullable(new Ticket(1L, 1L, "A1"));
//		Ticket expectedOutput = new Ticket(1L, 1L, "A1");
//		Mockito.when(this.repo.findById(testId)).thenReturn(mockOutputValid);
//		assertEquals(expectedOutput, this.service.readTicketByBookingId(testId));
//		Mockito.verify(this.repo, Mockito.times(1)).findById(testId);
//	}

	@Test
	public void testDelete() {
		Ticket deleteTicket = new Ticket(1L, 1L, "A1");

		Mockito.when(this.repo.findById(deleteTicket.getTicketId())).thenReturn(Optional.of(deleteTicket));
		this.service.deleteTicket(deleteTicket.getTicketId());
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(deleteTicket.getTicketId());
	}

}
