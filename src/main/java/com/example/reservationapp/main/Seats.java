package com.example.reservationapp.main;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flightseats")
public class Seats {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String flightnumber;
	private String flightseat;
	private boolean seatstatus;
	
	
	public Seats() {
	}
	
	
	public Seats(String flightnumber, String flightseat, boolean seatstatus) {
		super();
		this.flightnumber = flightnumber;
		this.flightseat = flightseat;
		this.seatstatus = seatstatus;
	}
	
	
	public Seats(Long id, String flightnumber, String flightseat, boolean seatstatus) {
		super();
		this.id = id;
		this.flightnumber = flightnumber;
		this.flightseat = flightseat;
		this.seatstatus = seatstatus;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFlightnumber() {
		return flightnumber;
	}
	public void setFlightnumber(String flightnumber) {
		this.flightnumber = flightnumber;
	}
	public String getFlightseat() {
		return flightseat;
	}
	public void setFlightseat(String flightseat) {
		this.flightseat = flightseat;
	}
	public boolean isSeatstatus() {
		return seatstatus;
	}
	public void setSeatstatus(boolean seatstatus) {
		this.seatstatus = seatstatus;
	}
	
	
	

	
}
