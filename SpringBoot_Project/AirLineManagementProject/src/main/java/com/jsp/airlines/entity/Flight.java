package com.jsp.airlines.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class Flight {
	
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	private int flight_Id;
	private String destination;
	private String flight_Date;
	private String flight_No;
	private String flight_Time;
	private String current_Loc;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="amount_Id")
	private Amount amount;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="flightInfo_Id")
	private Flight_Info flight_info;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="inventory_Id")
	private Inventory inventory;
	
}
