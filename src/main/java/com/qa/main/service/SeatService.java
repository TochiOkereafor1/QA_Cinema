package com.qa.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.main.domain.Seat;
import com.qa.main.repository.SeatRepository;

import java.util.List;
import java.util.Optional;

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
        if(optionalSeat.isPresent()) {
            return optionalSeat.get();
        }
        return null;
    }


    public Seat update(long id, Seat Seat) {
        Optional<Seat> existingSeat = this.repo.findById(id);
        if(existingSeat.isPresent()) {
            Seat existing = existingSeat.get();
            existing.setSeatId(Seat.getSeatId());
            existing.setRow_letter(Seat.getRow_letter());
            existing.setRow_number(Seat.getRow_number());
            return this.repo.saveAndFlush(existing);
        }

        return null;
    }


    public boolean delete(long id) {
        this.repo.deleteById(id);
        return !this.repo.existsById(id);
    }

}


    
    
    
    
    
    

