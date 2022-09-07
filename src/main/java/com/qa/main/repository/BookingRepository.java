package com.qa.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.main.domain.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

	@Query(value = "SELECT * from Booking", nativeQuery = true)
	public List<Booking> findAllBookings();

//	@Query(value = "SELECT * from Booking WHERE customerId = ?1", nativeQuery = true)
//	List<Booking> findBookingByCustomerSQL(Long customerId);

	@Query(value = "SELECT * from Booking WHERE emailAddress = ?1", nativeQuery = true)
	public List<Booking> findBookingByEmailAddressSQL(String emailAddress);

}
