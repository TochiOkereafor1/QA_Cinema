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

import com.qa.main.domain.Film;
import com.qa.main.service.FilmService;

@RestController
@RequestMapping("/film")
@ResponseBody
@ResponseStatus
@CrossOrigin
public class FilmController {
 
	@Autowired
	private FilmService service;
	
	public FilmController(FilmService service) {
		this.service = service; 
	}

	@GetMapping("/getFilms")
	public ResponseEntity<List<Film>> getFilms() {
		List<Film> filmData = service.getAllFilms();
		return new ResponseEntity<List<Film>>(filmData, HttpStatus.OK);
	}

	@GetMapping("/get/{filmID}")
	public ResponseEntity<Film> getFilmId(@PathVariable Long filmId) {
		Film filmInfo = service.readSingleFilm(filmId);
		return new ResponseEntity<Film>(filmInfo, HttpStatus.OK);

	}
	
	@PostMapping("/createFilm")
	public ResponseEntity<Film> createFilm(@RequestBody Film film){
		Film createFilm = service.createFilm(film); 
		return new ResponseEntity<Film>(createFilm, HttpStatus.CREATED); 
		
	}

}
