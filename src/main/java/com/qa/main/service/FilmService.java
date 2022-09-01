package com.qa.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.main.domain.Film;
import com.qa.main.repository.FilmRepository;

@Service
public class FilmService {
	
	private Film film; 
	
	@Autowired
	private FilmRepository repo; 
	
	public FilmService(FilmRepository repo) {
		this.repo = repo; 
		film = new Film();
	}
	
	public Film createFilm(Film film) {
		return repo.save(film); 
	}
	
	public Film readSingleFilm (Long filmId) {
		return this.repo.findById(filmId).get(); 
	}
	
	public List<Film> getAllFilms(){
		return this.repo.findAll();
	}

}
