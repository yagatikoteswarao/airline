package com.jsp.airlines.dto;

import java.util.List;

import com.jsp.airlines.entity.Booking_Information;
import com.jsp.airlines.entity.CheckIn;
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
public class PassengerDto {
	
	private String email_Id;
	private String firstName;
	private String lastName;
	private String gender;
	private String mobileNumber;
	
	private BookingInformationDto booking;
	
	private CheckInDto check;
	
}
