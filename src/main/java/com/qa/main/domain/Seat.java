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
@Table(name = "seats")
public class Seat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seatId;

	@Column(nullable = false)
	private char row_letter;

	@Column(nullable = false)
	private int row_number;

	@Autowired
	public Seat() {

	}

	@Autowired
	public Seat(Long seatId, char row_letter, int row_number) {
		this.seatId = seatId;
		this.row_letter = row_letter;
		this.row_number = row_number;
	}

	@Autowired
	public Seat(char row_letter, int row_number) {
		super();
		this.row_letter = row_letter;
		this.row_number = row_number;
	}

	@Override
	public String toString() {
		return "Seat [seatId=" + seatId + ", row_letter=" + row_letter + ", row_number=" + row_number + "]";
	}

	public Long getSeatId() {
		return seatId;
	}

	public void setSeatId(Long seatId) {
		this.seatId = seatId;
	}

	public char getRow_letter() {
		return row_letter;
	}

	public void setRow_letter(char row_letter) {
		this.row_letter = row_letter;
	}

	public int getRow_number() {
		return row_number;
	}

	public void setRow_number(int row_number) {
		this.row_number = row_number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(row_letter, row_number);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seat other = (Seat) obj;
		return row_letter == other.row_letter && row_number == other.row_number;
	}

}
