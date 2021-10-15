package com.example.reservationapp.main;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightSeatRepo extends JpaRepository<Seats, Long> {
	
	@Transactional
	@Modifying
	@Query(value="UPDATE flightseats SET seatstatus = false WHERE (flightseat = ?1 AND flightnumber = ?2)", nativeQuery=true)
	void occupySeat(String seat, String flight);
	
}
