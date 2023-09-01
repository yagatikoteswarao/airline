package com.jsp.airlines.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class CheckIn {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int checkIn_Id;
	private int seat_No;
	private int gate_No;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy="check")
	private Passenger passenger;
	

}
