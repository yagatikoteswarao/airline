package com.jsp.airlines.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.airlines.dto.AmountDto;
import com.jsp.airlines.dto.FlightDto;
import com.jsp.airlines.dto.InventoryDto;
import com.jsp.airlines.repository.FlightRepository;
import com.zaxxer.hikari.util.FastList;

@Service
public class FlightServiceImple implements FlightService {

	@Autowired
	private FlightRepository flightRepository;
	
	@Override
	public List<FlightDto> getAllFlights() {
		  return flightRepository.findAll().stream()
				 		.map(flightdb ->FlightDto.builder()
						 .current_Loc(flightdb.getCurrent_Loc())
						.destination(flightdb.getDestination())
						.flight_Date(flightdb.getFlight_Date())
						.flight_No(flightdb.getFlight_No())
						.amountdto(AmountDto.builder().amount(flightdb.getAmount().getAmount())
								.currency(flightdb.getAmount().getCurrency()).build())
						.inventory(InventoryDto.builder()
								.count(flightdb.getInventory().getCount())
								.build())
						.build()).collect(Collectors.toList());
		  
	}
	
	@Override
	public List<FlightDto> searchByFlightNo(String flightNo) {
		
		return getAllFlights().stream().filter(flight->flight.getFlight_No().equals(flightNo)).collect(Collectors.toList());
	}
	
	@Override
	public List<FlightDto> fetchFlightBylocdestDate(FlightDto flightDto) {
		
		return getAllFlights().stream().filter(flight -> flight.getCurrent_Loc().equals(flightDto.getCurrent_Loc())
				&& flight.getDestination().equals(flightDto.getDestination())
				&& flight.getFlight_Date().equals(flightDto.getFlight_Date()))
				.collect(Collectors.toList());
	}
	
	@Override
	public List<FlightDto> searchFlightByNoDateTime(FlightDto flightDto) {
		
		return  getAllFlights().stream().filter(flight -> flight.getFlight_No().equals(flightDto.getFlight_No())
				&& flight.getFlight_Date().equals(flightDto.getFlight_Date())
				&& flight.getFlight_Time().equals(flightDto.getFlight_Time()))
				.collect(Collectors.toList());
				
	}

	@Override
	public String deleteFlightById(int id) {
		flightRepository.deleteById(id);
		return "Record Deleted Succefully";
	}

}