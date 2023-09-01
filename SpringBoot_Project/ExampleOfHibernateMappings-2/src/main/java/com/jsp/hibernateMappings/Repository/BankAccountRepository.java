package com.jsp.hibernateMappings.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.hibernateMappings.entity.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, Integer> {
	
}
  