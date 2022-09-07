package com.qa.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.qa.main.domain.Ticket;
import com.qa.main.service.TicketService;

@RestController
@RequestMapping("/ticket")
@ResponseBody
@ResponseStatus
@CrossOrigin
public class TicketController {

	private List<Ticket> ticket = new ArrayList<>();

	@Autowired
	private TicketService service;

	public TicketController(TicketService service) {
		this.service = service;
	}
	
	@CrossOrigin
	@PostMapping("/createTicket")
	public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
		Ticket newTicket = service.createTicket(ticket);
		return new ResponseEntity<Ticket>(newTicket, HttpStatus.CREATED);
	}

	@GetMapping("/getTicketByBooking/{bookingId}")
	public ResponseEntity<Ticket> getTicketbyBooking(@PathVariable("bookingId") Long bookingId) {
		List<Ticket> ticket = service.readTicketByBookingId(bookingId);
		return new ResponseEntity<Ticket>((Ticket) ticket, HttpStatus.ACCEPTED);
	}

//	@GetMapping("/getTicketBySeat/{seatId}")
//	public ResponseEntity<Ticket> getTicketBySeat(@PathVariable("seatId") Seat seatId) {
//		Ticket ticket = service.readTicketBySeatId(seatId);
//		return new ResponseEntity<Ticket>(ticket, HttpStatus.ACCEPTED);
//	}

	@DeleteMapping("/deleteTicket/{ticketId}")
	public ResponseEntity<Boolean> deleteTicket(@PathVariable Long ticketId) {
		Boolean deletedTicket = service.deleteTicket(ticketId);

		return (deletedTicket) ? new ResponseEntity<Boolean>(deletedTicket, HttpStatus.NO_CONTENT)
				: new ResponseEntity<Boolean>(deletedTicket, HttpStatus.NOT_FOUND);
	}

//	@PutMapping("/updateTicket/{ticketId}")

}
