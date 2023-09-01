package com.jsp.airlines.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.DtoInstantiatingConverter;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.stereotype.Service;

import com.jsp.airlines.dto.BookingInformationDto;
import com.jsp.airlines.dto.PassengerDto;
import com.jsp.airlines.dto.UserDto;
import com.jsp.airlines.entity.Booking_Information;
import com.jsp.airlines.entity.CheckIn;
import com.jsp.airlines.entity.Passenger;
import com.jsp.airlines.entity.User;
import com.jsp.airlines.repository.BookingRepository;
import com.jsp.airlines.repository.PassengerRepository;
import com.jsp.airlines.repository.UserRepository;

@Service
public class UserServiceImple implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PassengerRepository pasRepo;
	
	@Autowired
	private BookingRepository bookingRepo;
	@Override
	public int registerUser(UserDto dto) {
		
			User build = User.builder()
								.firstName(dto.getFirstName())
								.lastName(dto.getLastName())
								.mobile_No(dto.getMobile_No())
								.gender(dto.getGender())
								.userName(dto.getUserName())
								.password(dto.getPassword())
								.build();
			
		return userRepo.save(build).getUser_Id();
	}
	
	@Autowired
	private PassengerRepository passRepo;
		
	String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	String time = new SimpleDateFormat("hh:mm").format(new Date());
	
	
	@Override
	public int registerPassenger(PassengerDto dto) {
		
		Passenger passenger = Passenger.builder()
		.email_Id(dto.getEmail_Id())
		.firstName(dto.getFirstName())
		.lastName(dto.getLastName())
		.gender(dto.getGender())
		.mobileNumber(dto.getMobileNumber())
		.booking(
				Booking_Information.builder()
				.booking_Date(date)
				.destination(dto.getBooking().getDestination())
				.amount(dto.getBooking().getAmount())
				.flight_Date(date)
				.flight_No(dto.getBooking().getFlight_No())
				.status(dto.getBooking().getStatus())
				.flight_Time(time)
				.current_Loc(dto.getBooking().getCurrent_Loc())
				.build())
		.check(CheckIn.builder()
				.seat_No(dto.getCheck().getSeat_No())
				.gate_No(dto.getCheck().getGate_No())
				.build())
				.build();
		return passRepo.save(passenger).getPassenger_Id();
	}


	@Override
	public List<PassengerDto> getPassengerByBookingId(int id) {
			List<Passenger> list = pasRepo.findByPassengerBybookingid(id);
			if (list.size() > 0) {
				List<PassengerDto> list1 =list.stream()
						.map(t -> PassengerDto.builder()
								.email_Id(t.getEmail_Id())
								.firstName(t.getFirstName())
								.lastName(t.getLastName())
								.gender(t.getGender())
								.mobileNumber(t.getMobileNumber())
								.build())
						.collect(Collectors.toList());
				return list1;
			} else {
				return null;
			}
		}


	@Override
	public List<User> userLogin(String username, String password) {
		
		List<User> u1 = userRepo.findByUsernameAndPassword(username, password);
		
		if (u1 != null) {
			
			return u1;
			
		} 
		else {
			
			return null;
			
		}
	}

	@Override
	public List<UserDto> getUserDataById(int id) {
		
		List<User> user = userRepo.findByUserById(id);
				
		if(user!=null)
		{
			return user.stream().map(u ->UserDto.builder()
					.firstName(u.getFirstName())
					.lastName(u.getLastName())
					.mobile_No(u.getMobile_No())
					.gender(u.getGender())
					.userName(u.getUserName())
					.password(u.getPassword())
					.build())
			.collect(Collectors.toList());
		}
		else
		{
			return null;
		}
		
				
	}


	@Override
	public List<Passenger> passengerLogin(String mobilenumber, String email) {
		
		if (pasRepo.findByPassengerlogin(mobilenumber, email) != null) {
			
			return pasRepo.findByPassengerlogin(mobilenumber, email);
		} 
		else {
			return null;
		}
	}


	@Override
	public List<BookingInformationDto> getBookingInfoById(int id) {
		
		List<Booking_Information> list = bookingRepo.findByBookingInfoBybookingid(id);
		if (list.size() > 0) {
			List<BookingInformationDto> list1 =list.stream()
					.map(b -> BookingInformationDto.builder()
							.booking_Date(b.getBooking_Date())
							.destination(b.getDestination())
							.amount(b.getAmount())
							.flight_Date(b.getFlight_Date())
							.flight_No(b.getFlight_No())
							.status(b.getStatus())
							.flight_Time(b.getFlight_Time())
							.current_Loc(b.getCurrent_Loc())
							.build())
					.collect(Collectors.toList());
			return list1;
	}
		else
		{
			return null;
		}
}
	
	@Override
	public boolean updateUserMobileNumber(int id, String mobilenumber) {
		
		Optional<User> update=userRepo.findById(id);
		User u1 =update.get();
		u1.setMobile_No(mobilenumber);
		User result= userRepo.save(u1);
			
		if(update!=null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
