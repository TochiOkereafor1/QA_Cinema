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
	private char seatRow;

	@Column(nullable = false)
	private int seatNumber;

	@Autowired
	public Seat() {

	}

	@Autowired
	public Seat(Long seatId, char seatRow, int seatNumber) {
		this.seatId = seatId;
		this.seatRow = seatRow;
		this.seatNumber = seatNumber;
	}

	@Autowired
	public Seat(char seatRow, int seatNumber) {
		super();
		this.seatRow = seatRow;
		this.seatNumber = seatNumber;
	}

	@Override
	public String toString() {
		return "Seat [seatId=" + seatId + ", seatRow=" + seatRow + ", seatNumber=" + seatNumber + "]";
	}

	public Long getSeatId() {
		return seatId;
	}

	public void setSeatId(Long seatId) {
		this.seatId = seatId;
	}

	public char getSeatRow() {
		return seatRow;
	}

	public void setSeatRow(char seatRow) {
		this.seatRow = seatRow;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(seatRow, seatNumber);
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
		return seatRow == other.seatRow && seatNumber == other.seatNumber;
	}

}
