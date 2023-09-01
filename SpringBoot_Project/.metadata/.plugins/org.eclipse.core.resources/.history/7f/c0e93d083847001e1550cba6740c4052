package com.jsp.airlines.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jsp.airlines.dto.PassengerDto;
import com.jsp.airlines.entity.Passenger;
import com.jsp.airlines.entity.User;

public interface PassengerRepository  extends JpaRepository<Passenger, Integer>{
	
	@Query("SELECT p1 FROM Passenger p1 WHERE p1.booking.booking_Id= :bId")
	List<Passenger> findByPassengerBybookingid(@Param("bId") int bookingId);
	
	@Query("SELECT  p1 FROM Passenger p1 WHERE p1.mobileNumber= :mNo AND p1.email_Id= :email")
	List<Passenger> findByPassengerlogin(@Param("mNo")String mobilenumber,@Param("email")String emailid);
}
