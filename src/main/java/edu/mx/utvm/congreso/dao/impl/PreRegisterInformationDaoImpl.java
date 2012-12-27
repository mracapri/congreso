package edu.mx.utvm.congreso.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.mx.utvm.congreso.dao.IPreRegisterInformationDao;
import edu.mx.utvm.congreso.dominio.PreRegisterInformation;
@Repository
public class PreRegisterInformationDaoImpl extends JdbcTemplate implements IPreRegisterInformationDao{
	
	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	public void create(PreRegisterInformation newInstance) {
		this.update(
				"INSERT INTO " +
				"PREREGISTER_INFORMATION(EMAIL, NAME, SECOND_NAME, THIRD_NAME, ID_UNIVERSITY, ID_OCUPATION) " +
				"VALUES(?,?,?,?,?,?)",
				new Object[] { 
					newInstance.getInformationAccount().getEmail(),
					newInstance.getName(),
					newInstance.getSecondName(),
					newInstance.getThirdName(),
					newInstance.getUniversity().getId(),
					newInstance.getOcupation().getId()
				});
	}

	@Override
	public PreRegisterInformation read(Integer id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void update(PreRegisterInformation transientObject) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public void delete(PreRegisterInformation persistentObject) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<PreRegisterInformation> findAll() {
		throw new UnsupportedOperationException();
	}
}
