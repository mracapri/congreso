package edu.mx.utvm.congreso.dao;

import edu.mx.utvm.congreso.dominio.InformationAccount;

public interface IInformationAccountDao extends Dao<InformationAccount, Integer>{
	InformationAccount findAccountWithEmail(String email);
}
