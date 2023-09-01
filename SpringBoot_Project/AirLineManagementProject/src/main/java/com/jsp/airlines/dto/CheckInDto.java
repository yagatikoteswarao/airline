package com.jsp.airlines.dto;

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
public class CheckInDto {

	
	private int seat_No;
	private int gate_No;
	
	private PassengerDto passenger;
}
