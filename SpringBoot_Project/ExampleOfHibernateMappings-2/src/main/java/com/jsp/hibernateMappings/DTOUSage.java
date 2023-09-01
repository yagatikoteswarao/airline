package com.jsp.hibernateMappings;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.jsp.hibernateMappings.dto.EmployeeDTO;
import com.jsp.hibernateMappings.service.EmployeeService;

//COnsider The Class as a Controller for now
@SpringBootApplication
public class DTOUSage {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DTOUSage.class, args);
		
		EmployeeService service = context.getBean(EmployeeService.class);
		
		Scanner scan =new Scanner(System.in);
		System.out.println("Enter Employee ID");
		EmployeeDTO employee = service.fetchEmployeeById(scan.nextInt());
		
		if(employee!=null)
		{
			System.out.println("Name :"+employee.getEName());
			System.out.println("Salary :"+employee.getSalary());
			System.out.println("Bank Account No :"+employee.getBankaccount().getAccountNo());
		}
		else
		{
			System.err.println("No Records Found");
		}
	}
	
	

}
