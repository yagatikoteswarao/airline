package com.jsp.airlines.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.airlines.dto.AilLineInfodto;
import com.jsp.airlines.dto.BookingInformationDto;
import com.jsp.airlines.dto.PassengerDto;
import com.jsp.airlines.dto.UserDto;
import com.jsp.airlines.service.UserService;

@RestController
@RequestMapping("/user/v1")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/registeruser")
	public ResponseEntity<String> registerUser(@RequestBody UserDto dto)
	{
		int userId=userService.registerUser(dto);
		if(userId!=0)
		{
			return ResponseEntity.status(HttpStatus.CREATED).body("User Id is:"+userId);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("User Not Inserted");
		}
	} 
	
	@PostMapping("/registerPassenger")
	public ResponseEntity<String> registerPassenger(@RequestBody PassengerDto dto)
	{
		int passengerId=userService.registerPassenger(dto);
		if(passengerId!=0)
		{
			return ResponseEntity.status(HttpStatus.CREATED).body("Passenger Id is:"+passengerId);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Passenger Not Inserted");
		}
	} 
	
	@GetMapping("/get/passengerdetailsbyid/{id}")
	public List<PassengerDto> fetchPassengerByBookingId(@PathVariable("id") int id)
	{
		List<PassengerDto> passenger=userService.getPassengerByBookingId(id);
		if(passenger!=null)
		{
			return userService.getPassengerByBookingId(id);
		}
		else
		{
			return null;
		}	
	}	
	
	@GetMapping("/login/{uName}/{password}")
	public ResponseEntity<String> userLoginreq(@PathVariable("uName") String username, @PathVariable("password") String password) {
		
		if (userService.userLogin(username, password) != null) {
			return ResponseEntity.status(HttpStatus.FOUND).body("login sucessfull");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("invalid login Credential ");
		}
	}
	
	@GetMapping("/getuserByid/{uId}")
	public List<UserDto> getUserById(@PathVariable("uId") int id)
	{
		if(userService.getUserDataById(id)!=null)
		{
		return userService.getUserDataById(id);
		}
		else
		{
			return null;
		}
	}
	
	@GetMapping("/passengerlogin/{mNo}/{emailid}")
	public ResponseEntity<String> passengerLoginbyMnoEmail(@PathVariable("mNo")String mobilenumber,@PathVariable("emailid")String emailid)
	{
		if(userService.passengerLogin(mobilenumber, emailid)!=null)
		{
			return ResponseEntity.status(HttpStatus.FOUND).body("Login Successfull");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("In valid Credentials");
		}
	}	
	
	@GetMapping("/getBookingInfoById/{bId}")
	public List<BookingInformationDto> findBookingInfoByBiId(@PathVariable("bId")int id)
	{
		List<BookingInformationDto> bookinginfo=userService.getBookingInfoById(id);
		if(bookinginfo!=null)
		{
			return userService.getBookingInfoById(id);
		}
		else
		{
			return null;
		}	
	}
	
	@GetMapping("/updateusermobilenumberbyid/{uid}/{umobileno}")
	public ResponseEntity<String> updateUserMobileNumber(@PathVariable("uid")int id,@PathVariable("umobileno")String Mobilenumber)
	{
		boolean updateUserMobileNumber = userService.updateUserMobileNumber(id, Mobilenumber);
		if(updateUserMobileNumber)
		{
			return ResponseEntity.status(HttpStatus.OK).body("Updated Successfully");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.GONE).body(" Not Updated");
		}
	}
}










