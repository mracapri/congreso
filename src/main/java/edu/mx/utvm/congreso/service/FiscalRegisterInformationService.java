package edu.mx.utvm.congreso.service;

import edu.mx.utvm.congreso.dominio.FiscalRegisterInformation;

public interface FiscalRegisterInformationService {
	void save(FiscalRegisterInformation fiscalRegisterInformation);
	FiscalRegisterInformation read(String email);
	FiscalRegisterInformation readByToken(String token);
	void update(FiscalRegisterInformation fiscalRegisterInformation);
}
