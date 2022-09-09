package com.qa.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qa.main.domain.Screening;

public interface ScreeningRepository extends JpaRepository<Screening, Long> {
	@Query(value ="SELECT * from Screening", nativeQuery =true)
	public List<Screening> findAllScreenings(); 
	
	@Query(value = "SELECT * from Screening WHERE emailAddress = ?1", nativeQuery = true)
	List<Screening> findScreeningByCustomerSQL(String emailAddress); 
	
}
