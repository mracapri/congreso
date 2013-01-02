package edu.mx.utvm.congreso.service;

import java.util.List;

import edu.mx.utvm.congreso.dominio.PreRegisterInformation;

public interface PreRegisterInformationService {
	void save(PreRegisterInformation preRegisterInformation);
	List<PreRegisterInformation> findAllPreRegisters();
	List<PreRegisterInformation> findAllPreRegistersByParamSearch(String searchParameter);
	boolean getPaymentStatus(String token);
	void changePaymentStatus(boolean status, String token);
	PreRegisterInformation findPreRegisterInformationByToken(String token);
}

