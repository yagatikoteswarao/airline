package com.jsp.airlines.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.airlines.dto.AilLineInfodto;
import com.jsp.airlines.dto.FlightDto;
import com.jsp.airlines.dto.PassengerDto;
import com.jsp.airlines.entity.AirLineInformation;
import com.jsp.airlines.entity.Amount;
import com.jsp.airlines.entity.Booking_Information;
import com.jsp.airlines.entity.Flight;
import com.jsp.airlines.entity.Flight_Info;
import com.jsp.airlines.entity.Inventory;
import com.jsp.airlines.entity.Passenger;
import com.jsp.airlines.entity.User;
import com.jsp.airlines.repository.AirLineRepository;
import com.jsp.airlines.repository.FlightRepository;
import com.jsp.airlines.repository.PassengerRepository;

import ch.qos.logback.core.net.SyslogOutputStream;

@Service
public class AdminServiceImple implements AdminService {

	@Autowired
	private AirLineRepository airrepository;
	
	@Autowired
	private FlightRepository flightRepo;
	
	
	String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	String time = new SimpleDateFormat("hh:mm").format(new Date());
	
	@Override
	public int addFlight(FlightDto dto,int id) {
		Optional<AirLineInformation> optional = airrepository.findById(id);
		if(optional.isPresent())
		{
			Flight flight = Flight.builder()
				.destination(dto.getDestination())
				.flight_Date(date)
				.flight_No(dto.getFlight_No())
				.flight_Time(time)
				.current_Loc(dto.getCurrent_Loc())
				.amount(Amount.builder()
						.amount(dto.getAmountdto().getAmount())
						.currency(dto.getAmountdto().getCurrency())
						.build())
				.flight_info(Flight_Info.builder()
						.flight_No(dto.getFlight_info().getFlight_No())
						.flight_Time(time)
						.flight_Type(dto.getFlight_info().getFlight_Type())
						.alineinf(optional.get())
						.build())
				.inventory(Inventory.builder()
						.count(dto.getInventory().getCount())
						.build())
				.build();
		
		return flightRepo.save(flight).getFlight_Id();
		}
		else
		{
			return 0;
		}
	}

	@Override
	public int addAirLineInfo(AilLineInfodto dto) {
		 AirLineInformation information=airrepository.save(AirLineInformation.builder()
				  .airLine_Name(dto.getAirLine_Name())
				  .build());
		return information.getAirline_id();
	}

	@Override
	public AilLineInfodto getAirlineInfoById(int id) {
		
		Optional<AirLineInformation> airline = airrepository.findById(id);
		if (airline.isPresent()) {
			AirLineInformation airlineInformation = airline.get();
				/* transfer entity to DTO */
			AilLineInfodto dto = AilLineInfodto.builder()
					.airLine_Name(airlineInformation.getAirLine_Name()).build();
			return dto;
		}
		else {
			return null;
		}
	}

	@Override
	public boolean updateAirlineName(int id, String airname) {
		
		Optional<AirLineInformation> update=airrepository.findById(id);
		AirLineInformation u1 =update.get();
		u1.setAirLine_Name(airname);
		AirLineInformation result= airrepository.save(u1);
			
		if(update!=null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean updateFlightNumTimeNameById(int id,String flightNo, String time) {
		
		
		Optional<Flight> update=flightRepo.findById(id);
		Flight u1 =update.get();
		u1.setFlight_No(flightNo);
		u1.setFlight_Time(time);
		Flight result= flightRepo.save(u1);
			
		if(update!=null)
		{
			return true;
		}
		else
		{
			return false;
		}
		
			}

//	@Override
//	public List<AilLineInfodto> getAirlineInfoByName(String name) {
//		
//		
//		return null;
//	}

	@Override
	public String deleteAirLineById(int id) {
		
		airrepository.deleteById(id);
		return "Record deleted Successfullt";
			
	}

	
}
