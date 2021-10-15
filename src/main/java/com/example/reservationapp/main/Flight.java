package com.example.reservationapp.main;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "flightinfo")
public class Flight {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String flightnumber;
	private String flyingfrom; 
	private String flyingto;
	private String flightdate;
	private String flighttime;
	private String airline;
	private int price;
	
	public Flight() {
	}
	


	public Flight(String flightnumber, String flyingfrom, String flyingto, String flightdate, String flighttime,
			String airline, int price) {
		super();
		this.flightnumber = flightnumber;
		this.flyingfrom = flyingfrom;
		this.flyingto = flyingto;
		this.flightdate = flightdate;
		this.flighttime = flighttime;
		this.airline = airline;
		this.price = price;
	}



	public Flight(Long id, String flightnumber, String flyingfrom, String flyingto, String flightdate,
			String flighttime, String airline, int price) {
		super();
		this.id = id;
		this.flightnumber = flightnumber;
		this.flyingfrom = flyingfrom;
		this.flyingto = flyingto;
		this.flightdate = flightdate;
		this.flighttime = flighttime;
		this.airline = airline;
		this.price = price;
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

	public String getFlyingfrom() {
		return flyingfrom;
	}

	public void setFlyingfrom(String flyingfrom) {
		this.flyingfrom = flyingfrom;
	}

	public String getFlyingto() {
		return flyingto;
	}

	public void setFlyingto(String flyingto) {
		this.flyingto = flyingto;
	}

	public String getFlightdate() {
		return flightdate;
	}

	public void setFlightdate(String flightdate) {
		this.flightdate = flightdate;
	}

	public String getFlighttime() {
		return flighttime;
	}

	public void setFlighttime(String flighttime) {
		this.flighttime = flighttime;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getAirline() {
		return airline;
	}
	
	public void setAirline(String airline) {
		this.airline = airline;
	}

	
	

	
	
	
	
	
}
