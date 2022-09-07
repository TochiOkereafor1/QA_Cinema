package com.qa.main.domain;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "Screening")
public class Screening {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long screeningId;
	
	@Column(nullable = false)
	private String date;

	@Column(nullable = false)
	private String time;

	@Column
	private Long filmId;
	
	@Column
	private Long total; 

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "screeningId", referencedColumnName = "screeningId")
	private List<Booking> bookings;

//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "screeningId", referencedColumnName = "screeningId")
//	private Booking booking;

	// test constructor
	@Autowired
	public Screening(Long screeningId, String date, String time, Long filmId) {
		super();
		this.screeningId = screeningId;
		this.date = date; 
		this.time = time;
		this.filmId = filmId;
	}

	// production constructor
	@Autowired
	public Screening(String date, String time, Long filmId, Long total) {
		super();
		this.date= date; 
		this.time = time;
		this.filmId = filmId;
		this.total =total;
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

	public Long getfilmId() {
		return filmId;
	}

	public void setfilmId(Long filmId) {
		this.filmId = filmId;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	@Autowired
	// Default constructor
	public Screening() {

	}

	@Override
	public String toString() {
		return "Screening [screeningId=" + screeningId + ", time=" + time + ", filmId=" + filmId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookings, filmId, time);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Screening other = (Screening) obj;
		return Objects.equals(bookings, other.bookings) && Objects.equals(filmId, other.filmId)
				&& Objects.equals(time, other.time);
	}

}
