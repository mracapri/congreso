package edu.mx.utvm.congreso.dao;

import java.util.List;

import edu.mx.utvm.congreso.dominio.PreRegisterInformation;

public interface IPreRegisterInformationDao extends Dao<PreRegisterInformation, Integer>{
	boolean getPaymentStatus(String token);
	void changePaymentStatus(boolean status, String token);
	PreRegisterInformation findPreRegisterInformationByToken(String token);
	List<PreRegisterInformation> findAllPreRegistersByParamSearch(String searchParameter);
	PreRegisterInformation findPreRegisterInformationByUserName(String userName);
	void updateName(PreRegisterInformation preRegisterInformation, String email);
	void createCapture(PreRegisterInformation newInstance);
	boolean getAssitence(String token);
	void setAssitence(String token);
}
