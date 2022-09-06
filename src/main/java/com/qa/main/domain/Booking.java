package com.qa.main.domain;

import java.util.List;

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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table
@Data
@ToString(exclude = { "tickets" })
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

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "bookingId", referencedColumnName = "bookingId")
//	@Exclude
	private List<Ticket> tickets;

	@Autowired
	public Booking(Long screeningId, String forename, String surname, String emailAddress) {
		this.screeningId = screeningId;
		this.forename = forename;
		this.surname = surname;
		this.emailAddress = emailAddress;
	}

	@Autowired
	public Booking(Long bookingId, String forename, String surname, String emailAddress, Long screeningId) {
		this.bookingId = bookingId;
		this.forename = forename;
		this.surname = surname;
		this.emailAddress = emailAddress;
		this.screeningId = screeningId;
	}

}
