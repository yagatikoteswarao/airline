package com.jsp.hibernateMappings.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.StandardException;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name="address_Table")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int addId;
	private String area;
	private String pincode;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="emp_id_fk")
	private Employee employee;

}
