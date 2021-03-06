package edu.mx.utvm.congreso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mx.utvm.congreso.dao.impl.OcupationDaoImpl;
import edu.mx.utvm.congreso.dao.impl.ParticipationDaoImpl;
import edu.mx.utvm.congreso.dao.impl.UniversityDaoImpl;
import edu.mx.utvm.congreso.dominio.Ocupation;
import edu.mx.utvm.congreso.dominio.Participation;
import edu.mx.utvm.congreso.dominio.University;
@Service
public class CatalogServiceImpl implements CatalogService {

	@Autowired
	private UniversityDaoImpl universityDao;
	
	@Autowired
	private OcupationDaoImpl ocupationDao;
	
	@Autowired
	private ParticipationDaoImpl participationDao;
	
	@Override
	public List<University> findAllUniversities() {		
		return universityDao.findAll();
	}

	@Override
	public List<Ocupation> findAllOcupations() {
		return ocupationDao.findAll();
	}
	
	@Override
	public List<Participation> findAllParticipations() {
		return participationDao.findAll();
	}

}
