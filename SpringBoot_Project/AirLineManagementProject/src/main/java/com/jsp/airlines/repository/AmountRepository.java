package com.jsp.airlines.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.airlines.entity.Amount;

public interface AmountRepository  extends JpaRepository<Amount, Integer>{

}
