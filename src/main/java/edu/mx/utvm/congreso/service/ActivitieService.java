package edu.mx.utvm.congreso.service;

import java.util.List;

import edu.mx.utvm.congreso.dominio.Activitie;

public interface ActivitieService {
	List<Activitie> findAllByEmail(String email);
	int asist(int idActivitie, String email);
	void deasist(int idActivitie, String email);
	List<Activitie> findActivitiesSelectedByEmail(String email);
}