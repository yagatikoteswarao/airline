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

import org.springframework.data.annotation.TypeAlias;

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
@Table(name="project_table")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int projectId;
	private String name;
	private String startDate;
	private String endDate;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "project")
	List<Employee> employee;
	
	

}








