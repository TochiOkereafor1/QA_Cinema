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
@Table(name = "films")
public class Film {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long filmId;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private Long duration;

	@Column(nullable = false)
	private String rating;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "filmId", referencedColumnName = "filmId")
	private List<Screening> screenings;

	@Autowired
	public Film() {

	}

	@Autowired
	public Film(Long filmId, String title, Long duration, String rating, List<Screening> screenings) {
		this.filmId = filmId;
		this.title = title;
		this.duration = duration;
		this.rating = rating;
		this.screenings = screenings;
	}

	@Autowired
	public Film(Long filmId, String title, Long duration, String rating) {
		this.filmId = filmId;
		this.title = title;
		this.duration = duration;
		this.rating = rating;
	}

	@Autowired
	public Film(String title, Long duration, String rating) {
		this.title = title;
		this.duration = duration;
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Film [filmId=" + filmId + ", title=" + title + ", duration=" + duration + ", rating=" + rating + "]";
	}

	public Long getFilmId() {
		return filmId;
	}

	public void setFilmId(Long filmId) {
		this.filmId = filmId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public List<Screening> getScreenings() {
		return screenings;
	}

	public void setScreenings(List<Screening> screenings) {
		this.screenings = screenings;
	}

	@Override
	public int hashCode() {
		return Objects.hash(duration, rating, screenings, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(duration, other.duration) && Objects.equals(rating, other.rating)
				&& Objects.equals(screenings, other.screenings) && Objects.equals(title, other.title);
	}

}
