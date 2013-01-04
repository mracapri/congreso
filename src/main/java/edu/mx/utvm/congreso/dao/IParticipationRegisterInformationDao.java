package edu.mx.utvm.congreso.dao;

import java.util.List;

import edu.mx.utvm.congreso.dominio.ParticipationRegisterInformation;

public interface IParticipationRegisterInformationDao extends Dao<ParticipationRegisterInformation, Integer>{
	ParticipationRegisterInformation findParticipationRegisterInformationByToken(String token);
	List<ParticipationRegisterInformation> findParticipationRegisterInformationByParamSearch(String searchParameter);
	
}
