package com.qa.main.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Exclude
	private Long bookingId;

	@Column(nullable = false)
	private String forename;

	@Column(nullable = false)
	private String surname;

	@Column(nullable = false)
	private String emailAddress;

	@Column(nullable = false)
	private Long screeningId;

	@Column(nullable = false, columnDefinition = "int default '0'")
	private int adultTickets;

	@Column(nullable = false, columnDefinition = "int default '0'")
	private int childTickets;

	@Column(nullable = false, columnDefinition = "int default '0'")
	private int concessionTickets;

	public Booking(String forename, String surname, String emailAddress, Long screeningId, int adultTickets,
			int childTickets, int concessionTickets) {
		this.forename = forename;
		this.surname = surname;
		this.emailAddress = emailAddress;
		this.screeningId = screeningId;
		this.adultTickets = adultTickets;
		this.childTickets = childTickets;
		this.concessionTickets = concessionTickets;
	}

}
