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
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private String forename;

	@Column(nullable = false)
	private String surname;

	@Column(nullable = false)
	private String emailAddress;

	@Autowired
	public Customer() {

	}

	@Autowired
	public Customer(long id, String forename, String surname, String emailAddress) {
		this.id = id;
		this.forename = forename;
		this.surname = surname;
		this.emailAddress = emailAddress;
	}

	@Autowired
	public Customer(String forename, String surname, String emailAddress) {
		this.forename = forename;
		this.surname = surname;
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", forename=" + forename + ", surname=" + surname + ", emailAdress=" + emailAddress
				+ "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getForename() {
		return forename;
	}

	public void setForename(String forename) {
		this.forename = forename;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public int hashCode() {
		return Objects.hash(emailAddress, forename, surname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(emailAddress, other.emailAddress) && Objects.equals(forename, other.forename)
				&& Objects.equals(surname, other.surname);
	}

}
