package com.qa.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.qa.main.domain.Seat;
        import com.qa.main.service.SeatService;

import java.util.List;

@RestController
@RequestMapping("/booking")
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

    @GetMapping("/readById/{id}")
    public ResponseEntity<Seat> readRecipesById(@PathVariable long id){
        return new ResponseEntity<Seat>(this.service.getById(id), HttpStatus.OK);
    }

    @GetMapping("/readAll")
    public ResponseEntity<List<Seat>> readAllSeat(){
        return new ResponseEntity<List<Seat>>(this.service.getAll(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Seat> updateRecipes(@PathVariable long id, @RequestBody Seat Seat){
        return new ResponseEntity<Seat>(this.service.update(id, Seat), HttpStatus.ACCEPTED);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteSeat(@PathVariable long id){
        //Line below uses a Ternary Operator, basically says IF service.delete method goes through, RETURN no content ELSE return not found
        return (this.service.delete(id)) ? new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT) :
                new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
    }












}

