package com.jsp.airlines.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jsp.airlines.entity.Booking_Information;
import com.jsp.airlines.entity.Passenger;

public interface BookingRepository  extends JpaRepository<Booking_Information, Integer>{

	@Query("SELECT b1 FROM Booking_Information b1 WHERE b1.booking_Id= :bId")
	List<Booking_Information> findByBookingInfoBybookingid(@Param("bId") int bookingId);
}
