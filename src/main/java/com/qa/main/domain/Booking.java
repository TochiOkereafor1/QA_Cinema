package com.qa.main.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookingId;

	@Column(nullable = false)
//	@JoinColumn(name = "screeningId")
//	@ManyToOne(targetEntity = Screening.class, fetch = FetchType.LAZY)
	private Long screeningId;

	@Column(nullable = false)
	private String forename;

	@Column(nullable = false)
	private String surname;

	@Column(nullable = false)
	private String emailAddress;

	public Booking(Long screeningId, String forename, String surname, String emailAddress) {
		this.screeningId = screeningId;
		this.forename = forename;
		this.surname = surname;
		this.emailAddress = emailAddress;
	}

}