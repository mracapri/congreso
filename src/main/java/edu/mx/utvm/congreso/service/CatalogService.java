package edu.mx.utvm.congreso.service;

import java.util.List;

import edu.mx.utvm.congreso.dominio.Ocupation;
import edu.mx.utvm.congreso.dominio.Participation;
import edu.mx.utvm.congreso.dominio.University;

public interface CatalogService {
	List<University> findAllUniversities();
	List<Ocupation> findAllOcupations();
	List<Participation> findAllParticipations();
}
