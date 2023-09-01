package com.jsp.airlines.dto;

import java.util.List;

import com.jsp.airlines.entity.Flight_Info;

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
public class UserDto {
	
	private String firstName;
	private String lastName;
	private String mobile_No;
	private String gender;
	private String userName;
	private String password;

}
