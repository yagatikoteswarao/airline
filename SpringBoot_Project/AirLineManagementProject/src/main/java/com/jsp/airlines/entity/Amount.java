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
public class Amount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int amount_Id;
	private double amount;
	private String currency;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "amount")
	private Flight flight;

}
