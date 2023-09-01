package com.jsp.hibernateMappings.service;

import com.jsp.hibernateMappings.dto.EmployeeDTO;

public interface EmployeeService {

	EmployeeDTO fetchEmployeeById(int id);
}
