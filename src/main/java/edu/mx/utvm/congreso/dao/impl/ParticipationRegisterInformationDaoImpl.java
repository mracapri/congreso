package edu.mx.utvm.congreso.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.mx.utvm.congreso.dao.IParticipationRegisterInformationDao;
import edu.mx.utvm.congreso.dominio.ParticipationRegisterInformation;
@Repository
public class ParticipationRegisterInformationDaoImpl extends JdbcTemplate
		implements IParticipationRegisterInformationDao {
	
	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	public void create(ParticipationRegisterInformation newInstance) {
		this.update(
				"INSERT INTO "
						+ "PARTICIPATION_REGISTER_INFORMATION"
						+ "(EMAIL, NAME, SECOND_NAME, THIRD_NAME, PHONE, ID_UNIVERSITY, ID_OCUPATION, ID_PARTICIPATION, PARTICIPATION_PDF_FILE, PARTICIPATION_PDF_FILE_NAME) "
						+ "VALUES(?,?,?,?,?,?,?,?,?,?)",
				new Object[] { 
					newInstance.getInformationAccount().getEmail(),
					newInstance.getName(),
					newInstance.getSecondName(),
					newInstance.getThirdName(),
					newInstance.getPhone(),
					newInstance.getUniversity().getId(),
					newInstance.getOcupation().getId(),
					newInstance.getParticipation().getId(),
					newInstance.getParticipationFile(),
					newInstance.getParticipationFileName()
				});
	}

	@Override
	public ParticipationRegisterInformation read(Integer id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void update(ParticipationRegisterInformation transientObject) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public void delete(ParticipationRegisterInformation persistentObject) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<ParticipationRegisterInformation> findAll() {
		throw new UnsupportedOperationException();
	}
}
