package com.jsp.airlines.entity;

import java.time.LocalTime;

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
public class Flight_Info {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int flightInfo_Id;
	private String flight_No;
	private String flight_Time;
	private String flight_Type;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="airline_id")
	private AirLineInformation alineinf;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "flight_info")
	private Flight flight;
	
}
