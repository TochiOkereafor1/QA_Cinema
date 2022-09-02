package com.qa.main.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "Screening")
public class Screening {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long screeningId;

	@Column(nullable = false)
	private String time;

	@JoinColumn(name = "filmId")
	@ManyToOne(targetEntity = Film.class)
	private Film filmId;

//    @OneToMany(mappedBy = "screeningId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Booking booking;

	// test constructor
	@Autowired
	public Screening(Long screeningId, String time, Film filmId) {
		super();
		this.screeningId = screeningId;
		this.time = time;
		this.filmId = filmId;
	}

	// production constructor
	@Autowired
	public Screening(String time, Film filmId) {
		super();
		this.time = time;
		this.filmId = filmId;
	}

	public Long getscreeningId() {
		return screeningId;
	}

	public void setscreeningId(Long screeningId) {
		this.screeningId = screeningId;
	}

	public String gettime() {
		return time;
	}

	public void settime(String time) {
		this.time = time;
	}

	public Film getfilmId() {
		return filmId;
	}

	public void setfilmId(Film filmId) {
		this.filmId = filmId;
	}

	@Autowired
	// Default constructor
	public Screening() {

	}

	@Override
	public String toString() {
		return "Screening [id=" + screeningId + ", time=" + time + ", filmId=" + filmId + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Screening Screening = (Screening) o;
		return time == Screening.time && filmId == Screening.filmId && filmId.equals(Screening.filmId)
				&& time.equals(Screening.time);
	}

	@Override
	public int hashCode() {
		return Objects.hash(time, filmId);
	}
}