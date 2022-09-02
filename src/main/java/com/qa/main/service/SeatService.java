package com.qa.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.main.domain.Seat;
import com.qa.main.repository.SeatRepository;

@Service
public class SeatService {

	private Seat seat;

	@Autowired
	private SeatRepository repo;

	public SeatService(SeatRepository repo) {
		this.repo = repo;
		seat = new Seat();
	}

	public Seat createSeat(Seat seat) {
		return repo.save(seat);
	}

	public List<Seat> getAll() {
		return this.repo.findAll();
	}

	public Seat getById(long id) {
		Optional<Seat> optionalSeat = this.repo.findById(id);
		if (optionalSeat.isPresent()) {
			return optionalSeat.get();
		}
		return null;
	}

	public Seat update(long id, Seat Seat) {
		Optional<Seat> existingSeat = this.repo.findById(id);
		if (existingSeat.isPresent()) {
			Seat existing = existingSeat.get();
			existing.setSeatId(Seat.getSeatId());
			existing.setSeatRow(Seat.getSeatRow());
			existing.setSeatNumber(Seat.getSeatNumber());
			return this.repo.saveAndFlush(existing);
		}

		return null;
	}

	public boolean delete(long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
