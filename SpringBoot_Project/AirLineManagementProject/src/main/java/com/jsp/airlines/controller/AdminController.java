package com.jsp.airlines.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.airlines.dto.AilLineInfodto;
import com.jsp.airlines.dto.FlightDto;
import com.jsp.airlines.dto.PassengerDto;
import com.jsp.airlines.service.AdminService;

@RestController
@RequestMapping("/airline/v")
public class AdminController {

	@Autowired
	private AdminService service;
	
	@PostMapping("/addairline")
	public ResponseEntity<String> addAirlineInfo(@RequestBody AilLineInfodto dto)
	{
		int airlineid=service.addAirLineInfo(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body("Airline Id is:"+airlineid);
	} 
	
	@PostMapping("/add/flight")
	public ResponseEntity<String> addflight(@RequestBody FlightDto dto, @PathVariable("id")int airlineId)
	{
		int flight=service.addFlight(dto,airlineId);
		if(flight!=0)
		{
			return ResponseEntity.status(HttpStatus.CREATED).body("Airline Id is:"+flight);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION).body("Flight is Not Added");
		}
	}
	
	@GetMapping("/get/airlineinfo/{id}")
	public ResponseEntity<String> fetchAirLine(@PathVariable("id") int id)
	{
		AilLineInfodto airline=service.getAirlineInfoById(id);
		if(airline!=null)
		{
			return ResponseEntity.status(HttpStatus.FOUND).body("AirLine Is Found "+airline);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("AirLine Is Not Found ");
		}	
	}
	
	@GetMapping("/updateairlinenamebyid/{id}/{airname}")
	public ResponseEntity<String> updateAirlineName(@PathVariable("id")int id,@PathVariable("airname")String airname)
	{
		boolean updateUserairname = service.updateAirlineName(id, airname);
		if(updateUserairname)
		{
			return ResponseEntity.status(HttpStatus.OK).body("Updated Successfully");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.GONE).body(" Not Updated");
		}
	}
	
	@GetMapping("/updateflightnotimeByid/{id}/{flightno}/{flighttime}")
	public ResponseEntity<String> updateFlightNoTimeById(@PathVariable("id")int id,@PathVariable("flightno")String flightno,
			@PathVariable("flighttime")String time)
	{
		boolean updateflighNoTime = service.updateFlightNumTimeNameById(id, flightno, time);
		if(updateflighNoTime)
		{
			return ResponseEntity.status(HttpStatus.OK).body("Updated Successfully");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.GONE).body(" Not Updated");
		}
	}
	
	@DeleteMapping("/deleteairlinebyid/{id}")
	public ResponseEntity<String> deleteAirlineById(@PathVariable("id")int id)
	{
		
		String deleteAirLineById = service.deleteAirLineById(id);
		if(deleteAirLineById != null)
		{
		return ResponseEntity.status(HttpStatus.GONE).body("Record Deleted Successfully");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Record Not Deleted");
		}
	}
	
	
}
