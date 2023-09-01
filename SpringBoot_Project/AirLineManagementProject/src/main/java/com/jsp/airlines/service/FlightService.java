package com.jsp.airlines.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jsp.airlines.dto.FlightDto;
import com.jsp.airlines.entity.Flight;

public interface FlightService {
		
	List<FlightDto> fetchFlightBylocdestDate(FlightDto flightDto);
	
	List<FlightDto> getAllFlights();
	
	List<FlightDto> searchByFlightNo(String flightNo);
	
	List<FlightDto> searchFlightByNoDateTime(FlightDto flightDto);
	
	String deleteFlightById(int id);
}