package com.jsp.airlines.service;

import java.util.List;

import org.apache.catalina.users.DataSourceUserDatabase;

import com.jsp.airlines.dto.BookingInformationDto;
import com.jsp.airlines.dto.PassengerDto;
import com.jsp.airlines.dto.UserDto;
import com.jsp.airlines.entity.Flight;
import com.jsp.airlines.entity.Passenger;
import com.jsp.airlines.entity.User;

public interface UserService {
	
	int registerUser(UserDto dto); 
	
	int registerPassenger(PassengerDto dto);
	
	List<PassengerDto> getPassengerByBookingId(int id);
	
	List<User> userLogin(String username, String password);
	
	List<UserDto> getUserDataById(int id);
	
	List<Passenger> passengerLogin(String mobilenumber,String email);
	
	List<BookingInformationDto> getBookingInfoById(int id);
	
	boolean updateUserMobileNumber(int id,String mobilenumber);
}
