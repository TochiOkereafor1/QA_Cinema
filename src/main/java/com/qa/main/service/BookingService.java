package com.qa.main.service;

import java.util.List;
import java.util.Optional;

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

	public Booking readBooking(Long bookingId) {
		return repo.findById(bookingId).get();
	}

	public List<Booking> readBooking2(String emailAddress) {
		return repo.findBookingByEmailAddressSQL(emailAddress);
	}

	public Booking updateBooking(Booking updateBooking, Long bookingId) {
		Optional<Booking> currentBooking = this.repo.findById(bookingId);
		Booking oldBooking = currentBooking.get();
		oldBooking.setForename(updateBooking.getForename());
		oldBooking.setForename(updateBooking.getSurname());
		oldBooking.setEmailAddress(updateBooking.getEmailAddress());
		oldBooking.setScreeningId(updateBooking.getScreeningId());
		return repo.save(oldBooking);
	}

	public boolean deleteBooking(Long bookingId) {
		Optional<Booking> currentBooking = this.repo.findById(bookingId);
		boolean isPresent = (currentBooking.isPresent()) ? true : false;
		if (isPresent) {
			this.repo.deleteById(bookingId);
			return true;
		} else {
			return false;
		}
	}

}
