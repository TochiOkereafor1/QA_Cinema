package com.qa.main.repository;

import com.qa.main.domain.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface SeatRepository extends JpaRepository<Seat, Long> {

    @Query(value = "SELECT * from Seat", nativeQuery = true)
    public List<Seat> findAllBookings();

    @Query(value = "SELECT * from Seat WHERE seatId = ?1", nativeQuery = true)
    List<Seat> findBookingByCustomerSQL(Long seatId);

}