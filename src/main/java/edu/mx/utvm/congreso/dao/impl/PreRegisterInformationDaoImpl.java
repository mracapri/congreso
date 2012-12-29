package edu.mx.utvm.congreso.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.mx.utvm.congreso.dao.IPreRegisterInformationDao;
import edu.mx.utvm.congreso.dominio.InformationAccount;
import edu.mx.utvm.congreso.dominio.Ocupation;
import edu.mx.utvm.congreso.dominio.PreRegisterInformation;
import edu.mx.utvm.congreso.dominio.University;
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
		String sql = "select ";
		sql = sql + 	"pi.email, pi.name, pi.second_name, pi.third_name, o.name, u.name, pi.payment_status ";
		sql = sql + "from ";
		sql = sql + 	"preregister_information pi, ocupation o, university u ";
		sql = sql + "where ";
		sql = sql + 	"o.id = pi.id_ocupation and u.id = pi.id_university";
		List<PreRegisterInformation> resultados = this.query(sql, new RowMapper<PreRegisterInformation>() {
			@Override
			public PreRegisterInformation mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Ocupation ocupation = new Ocupation();
				ocupation.setName(rs.getString("o.name"));
				
				University university = new University();
				university.setName(rs.getString("u.name"));
				
				InformationAccount account = new InformationAccount();
				account.setEmail(rs.getString("pi.email"));
				
				PreRegisterInformation preRegisterInformation = new PreRegisterInformation();
				preRegisterInformation.setName(rs.getString("pi.name"));
				preRegisterInformation.setSecondName(rs.getString("pi.second_name"));
				preRegisterInformation.setThirdName(rs.getString("pi.third_name"));
				preRegisterInformation.setPaymentStatus(rs.getString("pi.payment_status"));								
				preRegisterInformation.setInformationAccount(account);
				preRegisterInformation.setOcupation(ocupation);
				preRegisterInformation.setUniversity(university);
				
				return preRegisterInformation;
			}
		});
		return resultados;
	}
}
