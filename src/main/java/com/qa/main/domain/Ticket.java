package com.qa.main.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Entity
@Table(name = "Tickets")
@Data
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ticketId;

	@JoinColumn(name = "bookingId")
	@NotNull
	@ManyToOne(targetEntity = Booking.class)
	private Booking bookingId;

	@JoinColumn(name = "seatId")
	@NotNull
	@ManyToOne(targetEntity = Seat.class)
	private Seat seatId;

	@Autowired
	public Ticket() {

	}

	@Autowired
	public Ticket(Long ticketId, Booking bookingId, Seat seatId) {
		super();
		this.ticketId = ticketId;
		this.bookingId = bookingId;
		this.seatId = seatId;
	}

	@Autowired
	public Ticket(Booking bookingId, Seat seatId) {
		super();
		this.bookingId = bookingId;
		this.seatId = seatId;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", bookingId=" + bookingId + ", seatId=" + seatId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(seatId, bookingId);
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
		return Objects.equals(seatId, other.seatId) && Objects.equals(bookingId, other.bookingId);
	}

}
