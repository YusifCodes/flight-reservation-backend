package com.example.reservationapp.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AppService {
	
	@Autowired
	private FlightInfoRepo flightInfoRepo;
	
	@Autowired
	private FlightPassengerRepo flightPassengerRepo;
	
	@Autowired
	private FlightSeatRepo flightSeatRepo;

//	--------------
//	APPLICATION CASES
//	--------------
	
	
	List<Flight> getFlights(String from, String to) {
		
		List<Flight> finalFlightList = new ArrayList<Flight>();
		List<Flight> flights = flightInfoRepo.findAll();
		
		for(int i = 0; i <= flights.size() - 1; i++) {

			if(flights.get(i).getFlyingfrom().equals(from) && flights.get(i).getFlyingto().equals(to)) {
				
				finalFlightList.add(flights.get(i));
				
			}
			
		}
		
		return finalFlightList;
	}
	
	List<Flight> getAllFlights() {
			List<Flight> flights = flightInfoRepo.findAll();
			
			return flights;
		}
	
	
	List<Seats> getSeatsForFlight(String flightNumber) {
		
		List<Seats> finalSeatsList = new ArrayList<Seats>();
		List<Seats> flightSeats = flightSeatRepo.findAll();
		
		for(int i = 0; i <= flightSeats.size() - 1; i++) {
			
			if(flightSeats.get(i).getFlightnumber().equals(flightNumber)) {
				
				finalSeatsList.add(flightSeats.get(i));
				
			}
			
		}
		
		return finalSeatsList;
	}
	
	
	void setPassenger(com.fasterxml.jackson.databind.JsonNode passenger) {
				
		String firstname = passenger.get("firstname").textValue();
		String lastname = passenger.get("lastname").textValue();
		String passportnumber = passenger.get("passportnumber").textValue();
		String email = passenger.get("email").textValue();
		String address = passenger.get("address").textValue();
		String flightnumber = passenger.get("flightnumber").textValue();;
		String seat = passenger.get("seat").textValue();
		
		Passenger flightPassenger = new Passenger(firstname, lastname, passportnumber, email, address, flightnumber, seat);

		if(flightPassengerRepo.ticketExists(seat) == false) {
			
			flightPassengerRepo.save(flightPassenger);
			changeSeatStatus(seat, flightnumber);
			confirmationMail(firstname, flightnumber, seat, email);
			
		}else{
			System.out.print("QUERY ALREADY EXISTS");
		};
		
	}
	
	
	void changeSeatStatus(String seat, String flightnumber) {
		
		flightSeatRepo.occupySeat(seat, flightnumber);
		
	}

	
	
	void confirmationMail (String firstname, String flightnumber, String seat, String email) {
		String to = email;
		
		String from = "malikovbussiness@gmail.com";
		final String username = "malikovbusiness@gmail.com";
		final String password = "Iloveturtles123";
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.ssl.protocols", "TLSv1.2");
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.port", "587");
	    
	    
	    Session session = Session.getInstance(props, 
	    		new javax.mail.Authenticator() {
	    			protected PasswordAuthentication getPasswordAuthentication() {
	    				return new PasswordAuthentication(username, password);
	    			}
	    	}
	    );
	    
	    try {
	    	Message message = new MimeMessage(session);
	    	
	    	message.setFrom(new InternetAddress(from));
	    	
	    	message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
	    	
	    	message.setSubject("RESERVATION SUCCESSFUL");
	    	
	    	message.setContent(String.format("%s", "Hello "+ firstname + ". Thank you for using Yusif's ticket reserver. <br><br> Your flight number: " + flightnumber  + "<br> Your seat: " + seat + "<br><br>Thank you for choosing us!" ),
	                "text/html");
	    	
	    	Transport.send(message);
	    	System.out.println("success");
	    	System.out.println(to);
	    	
	    } catch(MessagingException e){
	    	e.printStackTrace();
	    	throw new RuntimeException(e);
	    }
	}

	
	
//	--------------	
//	TABLE ALTERING CASES
//	--------------	
	
	void setFlight() {
		Flight newFlight = new Flight("J1010", "BAKU", "MOSCOW", "2021-11-19", "22:30:00", "AZAL", 200);
		flightInfoRepo.save(newFlight);
		
		setSeats("J1010");
	}
	
	void setSeats(String flight) {
		
		String[] stringArr = {"a", "b", "c", "d", "e", "f"};
		
		for(int i = 1; i <= 28; i++) {
			for(int j = 0; j <= stringArr.length - 1; j++) {
				String currentSeat = "" + stringArr[j] + " " + i;
				Seats newSeat = new Seats(flight, currentSeat, true);
				flightSeatRepo.save(newSeat);
			}
		}
	}
	
	
}
