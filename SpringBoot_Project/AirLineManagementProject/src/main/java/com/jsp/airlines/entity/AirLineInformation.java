package com.jsp.airlines.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

public class AirLineInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int airline_id;
	private String airLine_Name;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "alineinf")
	private List<Flight_Info> flghinfo;
	
}











