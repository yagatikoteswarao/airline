package com.jsp.hibernateMappings.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name="Department_Table")
public class Department {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int deptId;
	private String dName;
	private String location;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "department")
	List<Employee> employee;
	
	
	

}
