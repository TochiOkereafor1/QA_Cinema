package com.qa.main.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Entity
@Table(name = "Tickets")
@Data
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ticketId;

	@Column(nullable = false)
	private Long bookingId;

	@Column
	private String seatRef;

	@Autowired
	public Ticket() {

	}

	@Autowired
	public Ticket(Long ticketId, Long bookingId, String seatRef) {
		this.ticketId = ticketId;
		this.bookingId = bookingId;
		this.seatRef = seatRef;
	}

	@Autowired
	public Ticket(Long bookingId, String seatRef) {
		this.bookingId = bookingId;
		this.seatRef = seatRef;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", bookingId=" + bookingId + ", seatRef=" + seatRef + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		return Objects.equals(bookingId, other.bookingId) && Objects.equals(seatRef, other.seatRef)
				&& Objects.equals(ticketId, other.ticketId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookingId, seatRef, ticketId);
	}

//	public Ticket(Long ticketId, Long bookingId, List<Seat> seats) {
//		super();
//		this.ticketId = ticketId;
//		this.bookingId = bookingId;
//		this.seats = seats;
//	}

}
