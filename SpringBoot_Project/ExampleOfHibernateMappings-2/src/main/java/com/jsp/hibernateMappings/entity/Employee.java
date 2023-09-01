package com.jsp.hibernateMappings.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name="emp_table")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eId;
	private String ename;
	private double salary;
	
	//Mapping
	//To Enable Operations For BankAccount
	@OneToOne(cascade = CascadeType.ALL)
	//TO Modify Foreign Key Coloumn Name
	@JoinColumn(name="bankAccountId")
	private BankAccount account;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "employee")
	List<Address> address;
	

	@ManyToMany(cascade = CascadeType.ALL)
	List<TechnicalSkills> skills;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="deptId_fk")
	private Department department;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="eduId_fk")
	private EducationalDetails eduDetails;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="proId_fk")
	private Project project;
}



















