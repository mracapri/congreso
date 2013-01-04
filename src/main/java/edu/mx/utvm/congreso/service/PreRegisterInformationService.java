package edu.mx.utvm.congreso.service;

import java.util.List;

import edu.mx.utvm.congreso.dominio.PreRegisterInformation;

public interface PreRegisterInformationService {
	void save(PreRegisterInformation preRegisterInformation);
	boolean getPaymentStatus(String token);
	void changePaymentStatus(boolean status, String token);
	List<PreRegisterInformation> findAllPreRegisters();
	List<PreRegisterInformation> findAllPreRegistersByParamSearch(String searchParameter);
	PreRegisterInformation findPreRegisterInformationByToken(String token);
}

