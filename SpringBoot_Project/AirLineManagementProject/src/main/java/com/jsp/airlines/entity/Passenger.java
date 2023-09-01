package com.jsp.airlines.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Passenger {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int passenger_Id;
	private String email_Id;
	private String firstName;
	private String lastName;
	private String gender;
	private String mobileNumber;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="booking_Id")
	private Booking_Information booking;
	
	
	@OneToOne(cascade = CascadeType.ALL) 
	@JoinColumn(name="checkIn_Id")
	private CheckIn check;
}






