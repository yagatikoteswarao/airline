package com.jsp.hibernateMappings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.jsp.hibernateMappings.Dao.BankAccountDa;
import com.jsp.hibernateMappings.Dao.EmployeeDao;
import com.jsp.hibernateMappings.entity.BankAccount;
import com.jsp.hibernateMappings.entity.Employee;

@SpringBootApplication
public class ExampleOfHibernateMappings2Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(ExampleOfHibernateMappings2Application.class, args);
		EmployeeDao dao = context.getBean(EmployeeDao.class);
		
//		BankAccount account = new BankAccount();
//		account.setAccountNo("SBI-1234567890");
//		account.setIFSCcode("SBI-00007");
//	
//		Employee emp = new Employee();
//		emp.setEname("qwerty");
//		emp.setSalary(30000);
//		emp.setAccount(account);
	
//		BankAccount A1 = BankAccount.builder().accountNo("SBI-1234567890").IFSCcode("SBI-00007").build()
		
		//From EMployee To BAnkAccount
//		Employee emp = Employee.builder()
//				.salary(30000)
//				.ename("qwerty")
//				.
//(BankAccount.builder().accountNo("SBI-1234567890").IFSCcode("SBI-00007").build())
//				.build();
//		
//		int id =dao.saveEmployee(emp);
//		System.out.println("Id Of EMployee is "+id);
		
		BankAccountDa dao1 = context.getBean(BankAccountDa.class);
		//From BankAccount To Employee
		Employee e1 = Employee.builder().ename("XYZ").salary(45000).build();
		BankAccount b1=BankAccount.builder().accountNo("SBI-0987654321").IFSCcode("SBI-004").employee(e1).build();
		e1.setAccount(b1);//To Insert If Of BankAccount in Employee Table
		//System.out.println("BankAccount id is"+dao1.saveBankAccount(b1));
		
		}

}
