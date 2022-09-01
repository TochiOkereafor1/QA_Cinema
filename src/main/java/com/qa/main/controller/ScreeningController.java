package com.qa.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.qa.main.domain.Screening;
import com.qa.main.service.ScreeningService;


public class ScreeningController {
	
	public ScreeningService service; 
	
	@Autowired
	public ScreeningController(ScreeningService service) {
		this.service = service;
	}
	@GetMapping("/getScreenings")
	public ResponseEntity<List<Screening>> getScreenings(){
		List<Screening> screeningData = service.getAllScreenings();
		return new ResponseEntity<List<Screening>>(screeningData, HttpStatus.OK);
	}
	
	@GetMapping("/get/{screeningId}")
	public ResponseEntity<Screening> getScreeningId(@PathVariable Long screeningId){
		Screening screeningInfo = service.readSingleScreening(screeningId);
		return new ResponseEntity<Screening>(screeningInfo, HttpStatus.OK); 
	}

}
