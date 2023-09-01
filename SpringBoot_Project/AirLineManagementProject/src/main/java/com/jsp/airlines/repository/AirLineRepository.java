package com.jsp.airlines.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jsp.airlines.entity.AirLineInformation;

public interface AirLineRepository extends JpaRepository<AirLineInformation, Integer> {

//	@Query("SELECT a1 FROM Author a1 WHERE a1.authorName=:authorName")
//	public Author findByAuthorsByName(@Param("authorName") String aName);
}
