package com.qa.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.main.domain.Booking;
import com.qa.main.repository.BookingRepository;

@Service
public class BookingService {

	private Booking booking;

	@Autowired
	private BookingRepository repo;

	public BookingService(BookingRepository repo) {
		this.repo = repo;
		booking = new Booking();
	}

	public Booking createBooking(Booking booking) {
		return repo.save(booking);
	}

}
