package com.example.reservationapp.main;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flightpassengers")
public class Passenger {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstname;
	private String lastname;
	private String passportnumber;
	private String email;
	private String address;
	private String flightnumber;
	private String seats;
	

	public Passenger() {
		super();
	}
	
	
	
	public Passenger(String firstname, String lastname, String passportnumber, String email, String address,
			String flightnumber, String seats) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.passportnumber = passportnumber;
		this.email = email;
		this.address = address;
		this.flightnumber = flightnumber;
		this.seats = seats;
	}
	
	
	
	public Passenger(Long id, String firstname, String lastname, String passportnumber, String email, String address,
			String flightnumber, String seats) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.passportnumber = passportnumber;
		this.email = email;
		this.address = address;
		this.flightnumber = flightnumber;
		this.seats = seats;
	}
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPassportnumber() {
		return passportnumber;
	}
	public void setPassportnumber(String passportnumber) {
		this.passportnumber = passportnumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFlightnumber() {
		return flightnumber;
	}
	public void setFlightnumber(String flightnumber) {
		this.flightnumber = flightnumber;
	}
	public String getSeats() {
		return seats;
	}
	public void setSeats(String seats) {
		this.seats = seats;
	}
	
	
	
}
