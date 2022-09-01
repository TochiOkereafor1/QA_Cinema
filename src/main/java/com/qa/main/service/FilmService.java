package com.qa.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.qa.main.domain.Film;
import com.qa.main.repository.FilmRepository;

public class FilmService {
	
	private Film film; 
	
	@Autowired
	private FilmRepository repo; 
	
	public FilmService() {
		film = new Film();
	}
	
	public Film readSingleFilm (Long filmId) {
		return this.repo.findById(filmId).get(); 
	}
	
	public List<Film> getAllFilms(){
		return this.repo.findAll();
	}

}
