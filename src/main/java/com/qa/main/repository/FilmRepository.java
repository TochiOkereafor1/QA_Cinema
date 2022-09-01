package com.qa.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qa.main.domain.Film;

public interface FilmRepository extends JpaRepository<Film, Long> {
	@Query(value ="SELECT * from Film", nativeQuery =true)
	public List<Film> findAllFilms(); 
	
	@Query(value = "SELECT * from Film WEHRE screeningId =?1", nativeQuery = true)
	List<Film> findFilmsByScreeningSQL(Long screeningId); 

}
