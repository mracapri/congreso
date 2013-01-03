package edu.mx.utvm.congreso.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.mx.utvm.congreso.dao.IAcademyRegisterInformationDao;
import edu.mx.utvm.congreso.dominio.AcademyRegisterInformation;
@Repository
public class AcademyRegisterInformationDaoImpl extends JdbcTemplate implements IAcademyRegisterInformationDao{
	
	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	public void create(AcademyRegisterInformation newInstance) {
		this.update(
				"INSERT INTO " +
				"academy_information(EMAIL, NAME, INVESTIGATION_LINE, CONTACT, ID_UNIVERSITY) " +
				"VALUES(?,?,?,?,?)",
				new Object[] { 
					newInstance.getInformationAccount().getEmail(),
					newInstance.getName(),
					newInstance.getInvestigationLines(),
					newInstance.getContact(),
					newInstance.getUniversity().getId()
				});	
	}

	@Override
	public AcademyRegisterInformation read(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(AcademyRegisterInformation transientObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(AcademyRegisterInformation persistentObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AcademyRegisterInformation> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


}
