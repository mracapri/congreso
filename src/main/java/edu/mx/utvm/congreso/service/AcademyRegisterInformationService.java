package edu.mx.utvm.congreso.service;

import java.util.List;

import edu.mx.utvm.congreso.dominio.AcademyRegisterInformation;

public interface AcademyRegisterInformationService {
	void save(AcademyRegisterInformation academyRegisterInformation);
	AcademyRegisterInformation findAcademyRegisterInformationByToken(String token);
	List<AcademyRegisterInformation> findAllAcademyRegisterInformation();
}
