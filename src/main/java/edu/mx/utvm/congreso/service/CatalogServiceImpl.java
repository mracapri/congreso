package edu.mx.utvm.congreso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mx.utvm.congreso.dao.impl.UniversityDaoImpl;
import edu.mx.utvm.congreso.dominio.University;
@Service
public class CatalogServiceImpl implements CatalogService {

	private UniversityDaoImpl universityDao;
	
	@Override
	public List<University> findAllUniversities() {		
		return universityDao.findAll();
	}

	@Autowired
	public void setUniversityDao(UniversityDaoImpl universityDao) {
		System.out.println("* * * * * ES NULO: " + (universityDao == null));
		this.universityDao = universityDao;
	}

}
