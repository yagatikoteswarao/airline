package com.jsp.airlines.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.jsp.airlines.entity.Flight_Info;
import com.jsp.airlines.entity.Passenger;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class BookingInformationDto {
	
	private String booking_Date;
	private String destination;
	private double amount;
	private String flight_Date;
	private String flight_No;
	private String status;
	private String flight_Time;
	private String current_Loc;

	private List<PassengerDto> passenger;

}
