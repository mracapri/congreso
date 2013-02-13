package edu.mx.utvm.congreso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mx.utvm.congreso.dao.impl.FiscalInformationDaoImpl;
import edu.mx.utvm.congreso.dao.impl.InformationAccountDaoImpl;
import edu.mx.utvm.congreso.dominio.FiscalRegisterInformation;
import edu.mx.utvm.congreso.dominio.InformationAccount;
@Service
public class FiscalRegisterInformationServiceImpl implements FiscalRegisterInformationService{	

	@Autowired
	private FiscalInformationDaoImpl informationDao;
	
	@Autowired
	private InformationAccountDaoImpl accountDao;
	
	@Override
	public void save(FiscalRegisterInformation fiscalRegisterInformation) {		
		informationDao.create(fiscalRegisterInformation);
	}

	@Override
	public FiscalRegisterInformation read(String email) {
		return informationDao.read(email);
	}

	@Override
	public void update(FiscalRegisterInformation fiscalRegisterInformation) {
		informationDao.update(fiscalRegisterInformation);
	}
	
	public FiscalRegisterInformation readByToken(String token){
		InformationAccount findAccountWithToken = accountDao.findAccountWithToken(token);
		if(findAccountWithToken != null){
			return informationDao.read(findAccountWithToken.getEmail());	
		}else{
			return null;
		}
		
	}

}
