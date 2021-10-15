package com.example.reservationapp.main;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FlightInfoRepo extends JpaRepository<Flight, Long>{
	

}
