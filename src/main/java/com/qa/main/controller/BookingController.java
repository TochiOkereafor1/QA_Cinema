package com.qa.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.main.domain.Booking;
import com.qa.main.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	BookingService service;

	public BookingController(BookingService service) {
		this.service = service;
	}

	@PostMapping("/createBooking")
	public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
		Booking createBooking = service.createBooking(booking);
		return new ResponseEntity<Booking>(createBooking, HttpStatus.CREATED);
	}

}
