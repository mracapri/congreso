package edu.mx.utvm.congreso.dao;

import java.util.List;

import edu.mx.utvm.congreso.dominio.Activitie;
import edu.mx.utvm.congreso.dominio.ActivitieCount;

public interface IActivitieDao extends Dao<Activitie, Integer>{
	List<Activitie> findAllByEmail(String email);
	void asist(int idActivitie, String email);
	void deasist(int idActivitie, String email);
	boolean canAsistAtActivitie(String email, int h1, int h2, String day);
	int countActivitiesAsigned(int idActivitie);
	boolean haveAVisit(String email);
	boolean paySucced(String email);
	List<Activitie> findActivitiesSelectedByEmail(String email);
	List<ActivitieCount> reportStateCountAllActivities();
	List<ActivitieCount> reportStateCountAllActivitiesByUniversity(int idUniversity);
	List<String> getAssitenceNamesListForActivitie(int idActivitie);
	String getActivitieName(int idActivitie);
}
