package edu.mx.utvm.congreso.dao.advice;

import org.springframework.dao.DataAccessException;

public class ServiceThrowsAdvice {

	public void doRecoveryActionDataAccess(DataAccessException dataAccessEx)
			throws Exception {
		throw new Exception("Error en la capa de persistencia @congreso: ", dataAccessEx);
	}

}