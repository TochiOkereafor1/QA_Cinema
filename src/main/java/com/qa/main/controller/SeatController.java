package com.qa.main.controller;

import java.util.List;

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

import com.qa.main.domain.Seat;
import com.qa.main.service.SeatService;

@RestController
@RequestMapping("/seat")
@ResponseBody
@ResponseStatus
@CrossOrigin
public class SeatController {

	@Autowired
	SeatService service;

	public SeatController(SeatService service) {
		this.service = service;
	}

	@PostMapping("/createSeat")
	public ResponseEntity<Seat> createSeat(@RequestBody Seat seat) {
		Seat createSeat = service.createSeat(seat);
		return new ResponseEntity<Seat>(createSeat, HttpStatus.CREATED);
	}

	@GetMapping("/readById/{seatId}")
	public ResponseEntity<Seat> readSeatsById(@PathVariable long seatId) {
		return new ResponseEntity<Seat>(this.service.getById(seatId), HttpStatus.OK);
	}

	@GetMapping("/readAll")
	public ResponseEntity<List<Seat>> readAllSeat() {
		return new ResponseEntity<List<Seat>>(this.service.getAll(), HttpStatus.OK);
	}

	@PutMapping("/update/{seatId}")
	public ResponseEntity<Seat> updateSeats(@PathVariable long seatId, @RequestBody Seat Seat) {
		return new ResponseEntity<Seat>(this.service.update(seatId, Seat), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{seatId}")
	public ResponseEntity<Boolean> deleteSeat(@PathVariable long seatId) {
		// Line below uses a Ternary Operator, basically says IF service.delete method
		// goes through, RETURN no content ELSE return not found
		return (this.service.delete(seatId)) ? new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
	}

}
