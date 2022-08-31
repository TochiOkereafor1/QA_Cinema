package com.qa.main.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "films")
public class Film {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long filmID;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private Long duration;

	@Column(nullable = false)
	private String rating;

	@Autowired
	public Film() {

	}

	@Autowired
	public Film(Long filmID, String title, Long duration, String rating) {
		this.filmID = filmID;
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
		return "Film [filmID=" + filmID + ", title=" + title + ", duration=" + duration + ", rating=" + rating + "]";
	}

	public Long getFilmID() {
		return filmID;
	}

	public void setFilmID(Long filmID) {
		this.filmID = filmID;
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

	@Override
	public int hashCode() {
		return Objects.hash(duration, rating, title);
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
				&& Objects.equals(title, other.title);
	}

}
