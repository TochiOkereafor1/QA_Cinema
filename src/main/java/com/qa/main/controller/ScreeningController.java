package com.qa.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.qa.main.domain.Screening;
import com.qa.main.service.ScreeningService;

@RestController
@RequestMapping("/screening")
@ResponseBody
@ResponseStatus
@CrossOrigin
public class ScreeningController {

	@Autowired
	public ScreeningService service;

	public ScreeningController(ScreeningService service) {
		this.service = service;
	}

	@PostMapping("/createScreening")
	public ResponseEntity<Screening> createScreening(@RequestBody Screening screening) {
		Screening createScreening = service.createScreening(screening);
		return new ResponseEntity<Screening>(createScreening, HttpStatus.CREATED);

	}

	@GetMapping("/getScreenings")
	public ResponseEntity<List<Screening>> getScreenings() {
		List<Screening> screeningData = service.getAllScreenings();
		return new ResponseEntity<List<Screening>>(screeningData, HttpStatus.OK);
	}

	@GetMapping("/getScreening/{screeningId}")
	public ResponseEntity<Screening> getScreeningId(@PathVariable Long screeningId) {
		Screening screeningInfo = service.readSingleScreening(screeningId);
		return new ResponseEntity<Screening>(screeningInfo, HttpStatus.OK);
	}



}
