package edu.mx.utvm.congreso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mx.utvm.congreso.dao.impl.FiscalInformationDaoImpl;
import edu.mx.utvm.congreso.dominio.FiscalRegisterInformation;
@Service
public class FiscalRegisterInformationServiceImpl implements FiscalRegisterInformationService{	

	@Autowired
	private FiscalInformationDaoImpl informationDao;
	
	@Override
	public void save(FiscalRegisterInformation fiscalRegisterInformation) {		
		informationDao.create(fiscalRegisterInformation);
	}

}
