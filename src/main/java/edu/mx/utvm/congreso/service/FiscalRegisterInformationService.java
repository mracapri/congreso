package edu.mx.utvm.congreso.service;

import edu.mx.utvm.congreso.dominio.FiscalRegisterInformation;

public interface FiscalRegisterInformationService {
	void save(FiscalRegisterInformation fiscalRegisterInformation);
	FiscalRegisterInformation read(String email);
	void update(FiscalRegisterInformation fiscalRegisterInformation);
}
