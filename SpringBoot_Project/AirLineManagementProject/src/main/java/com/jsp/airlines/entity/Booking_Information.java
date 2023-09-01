package com.jsp.airlines.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table
public class Booking_Information {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int booking_Id;
	private String booking_Date;
	private String destination;
	private double amount;
	private String flight_Date;
	private String flight_No;
	private String status;
	private String flight_Time;
	private String current_Loc;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "booking")
	private List<Passenger> passenger;
	
	
}





