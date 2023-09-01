package com.jsp.hibernateMappings.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name="bankaccount_table")
public class BankAccount {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accountId;
	private String accountNo;
	private String IFSCcode;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "account")
	private Employee employee;
}












