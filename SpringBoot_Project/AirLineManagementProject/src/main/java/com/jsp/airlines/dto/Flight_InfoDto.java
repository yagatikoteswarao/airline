package com.jsp.airlines.dto;

import java.time.LocalTime;
import java.util.List;

import com.jsp.airlines.entity.AirLineInformation;
import com.jsp.airlines.entity.Flight;
import com.jsp.airlines.entity.Flight_Info;

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
public class Flight_InfoDto {

	
	private String flight_No;
	private String flight_Time;
	private String flight_Type;
	
	private AilLineInfodto alineinf;
	
	private FlightDto flight;
}