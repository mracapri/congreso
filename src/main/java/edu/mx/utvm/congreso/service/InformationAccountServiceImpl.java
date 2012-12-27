package edu.mx.utvm.congreso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mx.utvm.congreso.dao.impl.InformationAccountDaoImpl;
import edu.mx.utvm.congreso.dominio.InformationAccount;
@Service
public class InformationAccountServiceImpl implements InformationAccountService{

	@Autowired
	private InformationAccountDaoImpl accountDao;
	
	@Override
	public boolean existEmailAccount(String email) {
		InformationAccount findAccountWithEmail = accountDao.findAccountWithEmail(email);
		if(findAccountWithEmail == null){
			return false;
		}else {
			return true;
		}
	}

	@Override
	public void save(InformationAccount account) {
		accountDao.create(account);
	}

}
