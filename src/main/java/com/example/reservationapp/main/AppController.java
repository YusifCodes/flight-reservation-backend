package com.example.reservationapp.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:9000")
public class AppController {
	
	@Autowired
	private AppService appService;
	
//	ADDS A A FLIGHT TO flightinfo AND SEATS TO flightseats ACCORDINGLY
//	@GetMapping("/setFlight")
//	void setFlight() {
//		appService.setFlight();
//	}
	
//	GET FLIGHTS FOR SPECIFIC DESTINTAIONS
	@GetMapping("get/flights/{from}/{to}")
	List<Flight> getFlights(@PathVariable("from") String flyingFrom, @PathVariable("to") String flyingTo){
		
		List<Flight> flights = appService.getFlights(flyingFrom, flyingTo);
		return flights;
		
	}
	
//	GET ALL AVAILIABLE FLIGHTS
	@GetMapping("get/flights/all")
	List<Flight> getFlights(){
		
		List<Flight> flights = appService.getAllFlights();
		return flights;
		
	}
	
//	GET SEATS FOR SPECIFIED FLIGHTNUMBER
	@GetMapping("get/seats/{flightnumber}")
	List<Seats> getSeats(@PathVariable("flightnumber") String flightnumber){
		
		List<Seats> seats = appService.getSeatsForFlight(flightnumber);
		return seats;
		
	}
	
//	ADD A PASSENGER TO passengerinfo, CHANGE SEAT STATUS IN flightseats, SEND A CONFIRMATION EMAIL TO A USER SPECIFIED EMAIL
	@PostMapping("set/passenger")
	void setPassenger(@RequestBody com.fasterxml.jackson.databind.JsonNode passenger) {
		appService.setPassenger(passenger);
	}
}
