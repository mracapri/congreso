package edu.mx.utvm.congreso.service;

import edu.mx.utvm.congreso.dominio.InformationAccount;

public interface InformationAccountService {
	boolean existEmailAccount(String email);
	void save(InformationAccount account);
}