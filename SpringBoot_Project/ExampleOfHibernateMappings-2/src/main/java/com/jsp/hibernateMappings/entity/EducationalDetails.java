package com.jsp.hibernateMappings.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="education_table")
public class EducationalDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int qId;
	private String qualification;
	private double aggregate;
	private String area;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private EducationalDetails educationDetails;
	
	
}





