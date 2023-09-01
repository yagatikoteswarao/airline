package com.jsp.airlines.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.airlines.dto.FlightDto;
import com.jsp.airlines.dto.PassengerDto;
import com.jsp.airlines.repository.FlightRepository;
import com.jsp.airlines.service.AdminService;
import com.jsp.airlines.service.FlightService;
import com.zaxxer.hikari.util.FastList;

@RestController
@RequestMapping("/flight/v1")
public class FlightController {
	
	//create api to search flight based on starting location ,destination,flight date,flight name.
	
	@Autowired
	private FlightService flightService;
	
	@GetMapping("/getflightdetailsby")
	public List<FlightDto> getFlightBydetlocdate(@RequestBody FlightDto flightDto)
	{
		if(flightService.fetchFlightBylocdestDate(flightDto).size()>0)
		{
			return flightService.fetchFlightBylocdestDate(flightDto);
					//ResponseEntity.status(HttpStatus.FOUND).body("flight Found SuccessFully");
		}
		else
		{
			return null;//ResponseEntity.status(HttpStatus.NOT_FOUND).body("Flight Not Found");
		}
	}
	
	@GetMapping("/getbyflightno/{fno}")
	public List<FlightDto> searchByFlightNo(@PathVariable("fno") String flightNo)
	{
		if(flightService.searchByFlightNo(flightNo)!=null)
		{
			return flightService.searchByFlightNo(flightNo);
		 			
					//ResponseEntity.status(HttpStatus.FOUND).body("Flight is Fetched");
		}
		else
		{
			return null;
			//ResponseEntity.status(HttpStatus.NOT_FOUND).body("Flight Not Fetched");
		}
	}
	
	@GetMapping("/getallflights")
	public List<FlightDto>  fetchAllFlights()
	{
		if(flightService.getAllFlights()!=null)		{
		return  flightService.getAllFlights();
				//ResponseEntity.status(HttpStatus.FOUND).body("Fetched All Flights");
		}
		else
		{
			return null;//ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Fetched");
		}
	}
	
	@GetMapping("/getflightdetailsbynodatetime")
	public List<FlightDto> getFlightByNoDateTime(@RequestBody FlightDto dto)
	{
		if(flightService.searchFlightByNoDateTime(dto).size()>0)
		{
			return flightService.searchFlightByNoDateTime(dto);
					//ResponseEntity.status(HttpStatus.FOUND).body("flight Found SuccessFully");
		}
		else
		{
			return null;//ResponseEntity.status(HttpStatus.NOT_FOUND).body("Flight Not Found");
		}
	}		
	
	@DeleteMapping("/deleteflightbyid/{id}")
	public ResponseEntity<String> deleteAirlineById(@PathVariable("id")int id)
	{
		
		String deleteflightById = flightService.deleteFlightById(id);
		if(deleteflightById != null)
		{
		return ResponseEntity.status(HttpStatus.GONE).body("Record Deleted Successfully");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Record Not Deleted");
		}
	}
}









