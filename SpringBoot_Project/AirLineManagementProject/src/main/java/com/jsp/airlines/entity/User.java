package com.jsp.airlines.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class User {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	private int user_Id;
	private String firstName;
	private String lastName;
	private String mobile_No;
	private String gender;
	private String userName;
	private String password;

}
