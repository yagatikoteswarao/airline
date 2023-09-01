package com.jsp.airlines.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jsp.airlines.dto.FlightDto;
import com.jsp.airlines.entity.Flight;
import com.jsp.airlines.entity.Passenger;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
	
	@Query("SELECT f1 FROM Flight f1 WHERE f1.current_Loc= :loc AND f1.destination= :dest AND f1.flight_Date= :date")
	List<FlightDto> findByFlightByLocDesDateName(@Param("loc") String current_Loc,@Param("dest") String destination,@Param("date")String flight_Date);
	
	@Query("SELECT f1 FROM Flight f1 WHERE f1.flight_No= :no AND f1.flight_Date= :date AND f1.flight_Time= :time")
	List<FlightDto> findByFlightByNoDateTime(@Param("no") String no,@Param("date") String date,@Param("time")String time);
	
}
