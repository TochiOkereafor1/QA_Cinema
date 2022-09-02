package com.qa.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.qa.main.domain.Booking;
import com.qa.main.service.BookingService;

@RestController
@RequestMapping("/booking")
@ResponseBody
@ResponseStatus
@CrossOrigin
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

	@GetMapping("/getBooking/{bookingId}")
	public ResponseEntity<Booking> readBooking(@PathVariable Long bookingId) {
		Booking readBooking = service.readBooking(bookingId);
		return new ResponseEntity<Booking>(readBooking, HttpStatus.OK);
	}

	@PutMapping("/updateBooking/{bookingId}")
	public ResponseEntity<Booking> updateBooking(@RequestBody Booking booking, @PathVariable Long bookingId) {
		Booking updateBooking = service.updateBooking(booking, bookingId);
		return new ResponseEntity<Booking>(updateBooking, HttpStatus.OK);
	}

	@DeleteMapping("deleteBooking/{bookingId}")
	public ResponseEntity<Boolean> deleteBooking(@PathVariable Long bookingId) {
		Boolean deletedBooking = service.deleteBooking(bookingId);
		return (deletedBooking) ? new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
	}

}
