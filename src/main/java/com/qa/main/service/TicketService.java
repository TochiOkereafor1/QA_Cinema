package com.qa.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.main.domain.Ticket;
import com.qa.main.repository.TicketRepository;

@Service
public class TicketService {

	private Ticket ticket;

	@Autowired
	private TicketRepository repo;

	public TicketService(TicketRepository repo) {
		this.repo = repo;
		ticket = new Ticket();
	}

	public Ticket createTicket(Ticket ticket) {
		return repo.save(ticket);
	}

	public List<Ticket> readAllTickets() {
		return repo.findAll();
	}

	public Ticket readTicketByBookingId(Long bookingId) {
		List<Ticket> existing = repo.findTicketByBookingSQL(bookingId);
		return existing.get(0);
	}

	public Ticket readTicketBySeatId(Long seatId) {
		List<Ticket> existing = repo.findTicketBySeatSQL(seatId);
		return existing.get(0);
	}

	public boolean deleteTicket(long ticketId) {
		repo.deleteById(ticketId);
		boolean exists = repo.existsById(ticketId);
		return !exists;
	}

	public Ticket updateTicket(Long ticketId, Ticket newTicket) {
		Optional<Ticket> existingOptional = repo.findById(ticketId);
		Ticket existing = existingOptional.get();

		existing.setBookingId(newTicket.getBookingId());
		existing.setSeatId(newTicket.getSeatId());

		return null;
	}

	public Ticket updateTicketByBooking() {
		return null;
	}

	public Ticket updateTicketBySeat() {
		return null;
	}

}
