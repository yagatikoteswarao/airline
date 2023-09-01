package com.jsp.airlines.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.jsp.airlines.entity.Amount;
import com.jsp.airlines.entity.Flight_Info;
import com.jsp.airlines.entity.Inventory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class FlightDto {
	private int flight_Id;
	private String destination;
	private String flight_Date;
	private String flight_No;
	private String flight_Time;
	private String current_Loc;
	
	private AmountDto amountdto;
	
	private Flight_InfoDto flight_info;
	
	private InventoryDto inventory;
}
