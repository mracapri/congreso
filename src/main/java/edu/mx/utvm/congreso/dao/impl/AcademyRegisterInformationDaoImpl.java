package edu.mx.utvm.congreso.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.mx.utvm.congreso.dao.IAcademyRegisterInformationDao;
import edu.mx.utvm.congreso.dominio.AcademyRegisterInformation;
import edu.mx.utvm.congreso.dominio.InformationAccount;
import edu.mx.utvm.congreso.dominio.University;
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
		String sql = "";
		sql = sql +	"select ";
		sql = sql +		"aca.contact, aca.investigation_line, aca.email, ia.password, ia.token, aca.name, u.name ";
		sql = sql +	"from ";
		sql = sql +		"academy_information aca, university u, information_account ia ";
		sql = sql +	"where ";
		sql = sql +	"	u.id = aca.id_university and ia.email = aca.email order by aca.name";
		
		List<AcademyRegisterInformation> resultados = this.query(
				sql,  
				new RowMapper<AcademyRegisterInformation>() {
			@Override
			public AcademyRegisterInformation mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				University university = new University();
				university.setName(rs.getString("u.name"));
				
				InformationAccount account = new InformationAccount();
				account.setEmail(rs.getString("aca.email"));
				account.setToken(rs.getString("ia.token"));
				
				AcademyRegisterInformation information = new AcademyRegisterInformation();
				information.setName(rs.getString("aca.name"));
				information.setContact(rs.getString("aca.contact"));
				information.setInvestigationLines(rs.getString("aca.investigation_line"));
				information.setInformationAccount(account);
				information.setUniversity(university);
				
				return information;
			}
		});
		return resultados;
	}

	@Override
	public AcademyRegisterInformation findAcademyRegisterInformationByToken(
			String token) {
	    String sql = "";
	    sql = sql + "select ";
	    sql = sql + 	"aca.contact, aca.investigation_line, aca.email, ia.password, ia.token, aca.name, u.name ";
	    sql = sql + "from ";
	    sql = sql + 	"academy_information aca, university u, information_account ia ";
	    sql = sql + "where ";
	    sql = sql + 	"u.id = aca.id_university and ia.email = aca.email and ia.token = ? order by aca.name";
		try {
			AcademyRegisterInformation resultado = this.queryForObject(sql,
					new Object[] { token },
					new RowMapper<AcademyRegisterInformation>() {
						@Override
						public AcademyRegisterInformation mapRow(ResultSet rs,
								int rowNum) throws SQLException {

							University university = new University();
							university.setName(rs.getString("u.name"));
							
							InformationAccount account = new InformationAccount();
							account.setEmail(rs.getString("aca.email"));
							account.setToken(rs.getString("ia.token"));
							account.setPassword(rs.getString("ia.password"));
							
							AcademyRegisterInformation information = new AcademyRegisterInformation();
							information.setName(rs.getString("aca.name"));
							information.setContact(rs.getString("aca.contact"));
							information.setInvestigationLines(rs.getString("aca.investigation_line"));
							information.setInformationAccount(account);
							information.setUniversity(university);
							
							return information;
						}
					});
			return resultado;
		} catch (EmptyResultDataAccessException accessException) {
			return null;
		}
	}
}
