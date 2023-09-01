package com.jsp.hibernateMappings.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.hibernateMappings.Repository.EmployeeRepository;
import com.jsp.hibernateMappings.dto.BankAccountDTO;
import com.jsp.hibernateMappings.dto.EmployeeDTO;
import com.jsp.hibernateMappings.entity.Employee;

@Service
public class EmployeeServiceImple implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	
	@Override
	public EmployeeDTO fetchEmployeeById(int id) {
		
		//Call Method From Repository
		Optional<Employee> optional = repository.findByEmployeeId(id);
		//To check Wheather Record Is Present Or Not
		if(optional.isPresent())
		{
			//Retrieve Employee Data
			Employee employeeFromDB = optional.get();
			//Transfer Data From Entity To DTO
			EmployeeDTO finalEmployeeData= EmployeeDTO.builder()
					.eName(employeeFromDB.getEname())
					.salary(employeeFromDB.getSalary())
					.bankaccount(BankAccountDTO.builder()
							.accountNo(employeeFromDB.getAccount().getAccountNo())
							.IFSCcode(employeeFromDB.getAccount().getIFSCcode())
							.build())
					.build();
			return finalEmployeeData;
		}
		else
		{
			return null;	
		}	
	}
}

















