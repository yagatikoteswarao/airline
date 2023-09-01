package com.jsp.hibernateMappings;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.jsp.hibernateMappings.Dao.EmployeeDao;
import com.jsp.hibernateMappings.entity.Address;
import com.jsp.hibernateMappings.entity.BankAccount;
import com.jsp.hibernateMappings.entity.Employee;

@SpringBootApplication
public class MainClass {
	public static <T> void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(MainClass.class, args);
		
		EmployeeDao dao = context.getBean(EmployeeDao.class);
		
		Address a1  = Address.builder().area("MGBS").pincode("500075").build();
		Address a2 = Address.builder().area("AMEERPET").pincode("500068").build();
		Address a3 = Address.builder().area("MANIKONDA").pincode("500039").build();
		
		List<Address> listofAddress = new ArrayList<Address>();
		
		listofAddress.add(a3);
		listofAddress.add(a2);
		listofAddress.add(a1);
		
		Employee e1 = Employee.builder()
				.ename("surf")
				.salary(80000)
				.account(BankAccount.builder()
						.accountNo("ICICI-1234567890")
						.IFSCcode("ICICI-0004")
						.build())
				.address(listofAddress)
				.build();
//				
		//Functional Interface
		
//		Consumer<Address> t = new Consumer<Address>() {
//
//			@Override
//			public void accept(Address t) {
//				t.setEmployee(e1);	
//			}
//		};
		//TO Avoid Length Of Code we are using
//		
//		for (Address address : listofAddress) {
//			address.setEmployee(e1);
//		}
				listofAddress.forEach(t->t.setEmployee(e1));
				
				int employee = dao.saveEmployee(e1);
				System.out.println("Employee id = "+employee);
		
				
				
	}
}




















