package com.jsp.hibernateMappings.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.hibernateMappings.Repository.BankAccountRepository;
import com.jsp.hibernateMappings.entity.BankAccount;

@Component
public class BankAccountDaoImpl  implements BankAccountDa{

	@Autowired
	private BankAccountRepository repo;
	@Override
	public int saveBankAccount(BankAccount account) {
		return repo.save(account).getAccountId();
	}
	
}
