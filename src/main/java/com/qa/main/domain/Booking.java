package com.qa.main.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

	@NotNull
	@Size(min = 0, max = 20)
	@JoinColumn(name = "screeningId")
	@ManyToOne(targetEntity = Screening.class, fetch = FetchType.LAZY)
	private Long screeningId;

	@Column(nullable = false)
	private String forename;

	@Column(nullable = false)
	private String surname;

	@Column(nullable = false)
	private String emailAddress;

	public Booking(@NotNull @Size(min = 0, max = 20) Long screeningId, String forename, String surname,
			String emailAddress) {
		super();
		this.screeningId = screeningId;
		this.forename = forename;
		this.surname = surname;
		this.emailAddress = emailAddress;
	}

}