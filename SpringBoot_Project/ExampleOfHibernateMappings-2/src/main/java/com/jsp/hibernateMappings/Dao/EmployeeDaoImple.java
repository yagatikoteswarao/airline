package com.jsp.hibernateMappings.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.hibernateMappings.Repository.EmployeeRepository;
import com.jsp.hibernateMappings.entity.Employee;

@Component
public class EmployeeDaoImple  implements EmployeeDao{

	@Autowired
	private EmployeeRepository repo;
	
	@Override
	public int saveEmployee(Employee e1) {
		Employee employee = repo.save(e1);
		return employee.getEId();
		
	}

	@Override
	public Employee findEmployeeByID(int id) {
		
		return null;
	}
	

}
