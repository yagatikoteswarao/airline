package com.jsp.airlines.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.airlines.entity.Flight_Info;

public interface Flight_InfoRepository extends JpaRepository<Flight_Info, Integer> {

}
