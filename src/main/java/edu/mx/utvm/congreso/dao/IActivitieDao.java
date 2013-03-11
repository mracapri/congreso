package edu.mx.utvm.congreso.dao;

import java.util.List;

import edu.mx.utvm.congreso.dominio.Activitie;

public interface IActivitieDao extends Dao<Activitie, Integer>{
	List<Activitie> findAllByEmail(String email);
	void asist(int idActivitie, String email);
	void deasist(int idActivitie, String email);
	boolean canAsistAtActivitie(String email, int h1, int h2);
	int countActivitiesAsigned(int idActivitie);
}