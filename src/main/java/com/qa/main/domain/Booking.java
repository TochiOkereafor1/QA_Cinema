package com.qa.main.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookingID;

	@NotNull
	@Size(min = 0, max = 30)
	@JoinColumn(name = "customerId") // FK
	@OneToOne(targetEntity = Customer.class, fetch = FetchType.LAZY)
	private Long customerId;

	@NotNull
	@Size(min = 0, max = 20)
	@Column(name = "Screening_Id") // FK
	private Long screeningId;

	@Autowired
	public Booking() {
		super();
	}

	@Autowired
	public Booking(Long customerId, Long screeningId) {
		super();
		this.customerId = customerId;
		this.screeningId = screeningId;
	}

	@Autowired
	public Booking(Long bookingID, Long customerId, Long screeningId) {
		super();
		this.bookingID = bookingID;
		this.customerId = customerId;
		this.screeningId = screeningId;
	}

	public Long getBookingID() {
		return bookingID;
	}

	public void setBookingID(Long bookingID) {
		this.bookingID = bookingID;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getScreeningId() {
		return screeningId;
	}

	public void setScreeningId(Long screeningId) {
		this.screeningId = screeningId;
	}

	@Override
	public String toString() {
		return "Booking [bookingID=" + bookingID + ", customerId=" + customerId + ", screeningId=" + screeningId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookingID, customerId, screeningId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booking other = (Booking) obj;
		return Objects.equals(bookingID, other.bookingID) && Objects.equals(customerId, other.customerId)
				&& Objects.equals(screeningId, other.screeningId);
	}

}
