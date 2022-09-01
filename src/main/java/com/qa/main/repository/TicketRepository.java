package com.qa.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.main.domain.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

	@Query(value = "SELECT * from Ticket", nativeQuery = true)
	public List<Ticket> findAllTickets();

	@Query(value = "SELECT * from Ticket WHERE bookingId = ?1", nativeQuery = true)
	List<Ticket> findTicketByBookingSQL(Long bookingId);

	@Query(value = "SELECT * from Ticket WHERE seatId = ?1", nativeQuery = true)
	List<Ticket> findTicketBySeatSQL(Long seatId);

}
