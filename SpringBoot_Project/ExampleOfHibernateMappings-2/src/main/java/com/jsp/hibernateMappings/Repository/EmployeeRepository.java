package com.jsp.hibernateMappings.Repository;

import java.security.cert.PKIXRevocationChecker.Option;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jsp.hibernateMappings.entity.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee, Integer>{

	@Query("SELECT e1 FROM Employee e1 WHERE e1.eId= :id")
	Optional<Employee> findByEmployeeId(@Param("id") int id);
}
