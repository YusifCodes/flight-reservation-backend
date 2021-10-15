package com.example.reservationapp.main;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightPassengerRepo extends JpaRepository<Passenger, Long> {

	@Query(value="SELECT EXISTS(SELECT 1 FROM flightpassengers WHERE seats = ?1)", nativeQuery=true)
	boolean ticketExists(String seat);
	
}
