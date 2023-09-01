package com.jsp.hibernateMappings.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name="technical_skills_table")
public class TechnicalSkills {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int skillId;
	private String skillName;
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "skills")
	List<Employee> employee;
}
