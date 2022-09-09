package com.qa.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.main.domain.Screening;
import com.qa.main.repository.ScreeningRepository;

@Service
public class ScreeningService {

	private Screening screening;

	@Autowired
	private ScreeningRepository repo;

	public ScreeningService(ScreeningRepository repo) {
		this.repo = repo;
		screening = new Screening();
	}

	public Screening createScreening(Screening screening) {
		return repo.save(screening);
	}

	public List<Screening> getAllScreenings() {
		return this.repo.findAll();
	}

	public Screening readSingleScreening(Long screeningId) {
		return this.repo.findById(screeningId).get();
	}

}
