package edu.mx.utvm.congreso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mx.utvm.congreso.dao.impl.ActivitieDaoImpl;
import edu.mx.utvm.congreso.dominio.Activitie;
import edu.mx.utvm.congreso.dominio.ActivitieCount;
import edu.mx.utvm.congreso.dominio.ListAssistenceForActivitie;
@Service
public class ActivitieServiceImpl implements ActivitieService {

	
	@Autowired
	private ActivitieDaoImpl activitieDao;

	@Override
	public List<Activitie> findAllByEmail(String email) {
		return activitieDao.findAllByEmail(email);
	}

	@Override
	public int asist(int idActivitie, String email) {
		Activitie activitie = activitieDao.read(idActivitie);
		boolean canAsistAtActivitie = activitieDao.canAsistAtActivitie(email,
				activitie.getH1(), activitie.getH2(), activitie.getDay());
		boolean paySucced = activitieDao.paySucced(email);
		if(paySucced){
			if(canAsistAtActivitie){			
				int countActivitiesAsigned = activitieDao.countActivitiesAsigned(idActivitie);
				if(activitie.getCapacityMin() > 0 && countActivitiesAsigned <= activitie.getCapacityMax()){				
					if(activitie.getVisit().equals("SI")){					
						boolean haveAVisit = activitieDao.haveAVisit(email);
						if(haveAVisit){
							return 4; // have a visit
						}
					}
					activitieDao.asist(idActivitie, email);
					return 1; // ok	
				}else{
					return 2; // overload
				}
			}else{
				return 3; // can't assist
			}
		}else{
			return 5; // payment succed
		}
	}

	@Override
	public void deasist(int idActivitie, String email) {
		activitieDao.deasist(idActivitie, email);
	}

	@Override
	public List<Activitie> findActivitiesSelectedByEmail(String email) {
		return activitieDao.findActivitiesSelectedByEmail(email);
	}

	@Override
	public List<ActivitieCount> reportStateCountAllActivities() {
		return activitieDao.reportStateCountAllActivities();
	}

	@Override
	public List<ActivitieCount> reportStateCountAllActivitiesByUniversity(
			int idUniversity) {
		return activitieDao.reportStateCountAllActivitiesByUniversity(idUniversity);
	}

	@Override
	public ListAssistenceForActivitie assitenceNamesListForActivitie(
			int idActivitie) {
		ListAssistenceForActivitie list = new ListAssistenceForActivitie();
		if(idActivitie > 0){
			list.setNameActivitie(activitieDao.getActivitieName(idActivitie));
			list.setNames(activitieDao.getAssitenceNamesListForActivitie(idActivitie));
		}
		return list;
	}
}