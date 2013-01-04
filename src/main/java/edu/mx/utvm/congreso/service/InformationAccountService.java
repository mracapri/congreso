package edu.mx.utvm.congreso.service;

import java.util.Map;

import edu.mx.utvm.congreso.dominio.InformationAccount;

public interface InformationAccountService {
	boolean existEmailAccount(String email);
	void save(InformationAccount account);
	void confirmToken(String token, Map<String, String> params);
}