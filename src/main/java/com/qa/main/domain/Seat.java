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
	private String row;

	@Column(nullable = false)
	private Long number;

	@Autowired
	public Seat() {

	}

	@Autowired
	public Seat(Long seatId, String row, Long number) {
		this.seatId = seatId;
		this.row = row;
		this.number = number;
	}

	@Autowired
	public Seat(String row, Long number) {
		this.row = row;
		this.number = number;
	}

	@Override
	public String toString() {
		return "Seat [seatId=" + seatId + ", row=" + row + ", number=" + number + "]";
	}

	public Long getSeatId() {
		return seatId;
	}

	public void setSeatId(Long seatId) {
		this.seatId = seatId;
	}

	public String getRow() {
		return row;
	}

	public void setRow(String row) {
		this.row = row;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number, row);
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
		return Objects.equals(number, other.number) && Objects.equals(row, other.row);
	}

}
