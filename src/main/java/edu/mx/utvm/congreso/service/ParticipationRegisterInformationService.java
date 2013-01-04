package edu.mx.utvm.congreso.service;

import java.util.List;

import edu.mx.utvm.congreso.dominio.ParticipationRegisterInformation;

public interface ParticipationRegisterInformationService {
	void save(ParticipationRegisterInformation participationRegisterInformation);
	List<ParticipationRegisterInformation> findAllParticipationRegisters();
	List<ParticipationRegisterInformation> findAllParticipationRegistersByParamSearch(String searchParameter);
	ParticipationRegisterInformation findParticipationRegisterInformationByToken(String token);
}
