package com.qa.main.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.qa.main.domain.Film;
import com.qa.main.service.FilmService;



public class FilmController {
	
	private FilmService service;
	
	@GetMapping("/getFilms")
	public ResponseEntity<List<Film>> getFilms(){
		List<Film> filmData = service.getAllFilms(); 
		return new ResponseEntity<List<Film>>(filmData, HttpStatus.OK);
	}
	
	@GetMapping("/get/{filmID}")
	public ResponseEntity<Film> getFilmId(@PathVariable Long filmId) {
		Film filmInfo = service.readSingleFilm(filmId);
		return new ResponseEntity<Film>(filmInfo, HttpStatus.OK);

	}
	
}
