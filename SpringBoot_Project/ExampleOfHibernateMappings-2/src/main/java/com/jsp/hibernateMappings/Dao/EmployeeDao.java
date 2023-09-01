package com.jsp.hibernateMappings.Dao;

import com.jsp.hibernateMappings.entity.Employee;

public interface EmployeeDao {
	int saveEmployee(Employee e1);

	Employee findEmployeeByID(int id);
}
