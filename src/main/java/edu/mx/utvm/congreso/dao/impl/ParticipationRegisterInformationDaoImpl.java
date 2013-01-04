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

import edu.mx.utvm.congreso.dao.IParticipationRegisterInformationDao;
import edu.mx.utvm.congreso.dominio.InformationAccount;
import edu.mx.utvm.congreso.dominio.Ocupation;
import edu.mx.utvm.congreso.dominio.Participation;
import edu.mx.utvm.congreso.dominio.ParticipationRegisterInformation;
import edu.mx.utvm.congreso.dominio.University;
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
						+ "participation_register_information"
						+ "(EMAIL, NAME, SECOND_NAME, THIRD_NAME, PHONE, ID_UNIVERSITY, ID_OCUPATION, ID_PARTICIPATION, PARTICIPATION_PDF_FILE, PARTICIPATION_PDF_FILE_NAME, PARTICIPATION_NAME) "
						+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)",
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
					newInstance.getParticipationFileName(),
					newInstance.getParticipationName()
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
		String sql = "select ";
		sql = sql +		"pri.phone, p.name, pri.participation_pdf_file_name, pri.participation_name, pri.email, ia.password, ia.token, pri.name, pri.second_name, pri.third_name, o.name, u.name ";
		sql = sql + "from ";
		sql = sql + 	"participation_register_information pri, ocupation o, university u, information_account ia, participation p ";
		sql = sql + "where ";
		sql = sql + 	"p.id = pri.id_participation and o.id = pri.id_ocupation and u.id = pri.id_university and ia.email = pri.email order by pri.name";
		
		List<ParticipationRegisterInformation> resultados = this.query(
				sql,  
				new RowMapper<ParticipationRegisterInformation>() {
			@Override
			public ParticipationRegisterInformation mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Ocupation ocupation = new Ocupation();
				ocupation.setName(rs.getString("o.name"));
				
				University university = new University();
				university.setName(rs.getString("u.name"));
				
				Participation participation = new Participation();
				participation.setName(rs.getString("p.name"));
				
				InformationAccount account = new InformationAccount();
				account.setEmail(rs.getString("pri.email"));
				account.setToken(rs.getString("ia.token"));
				
				ParticipationRegisterInformation information = new ParticipationRegisterInformation();
				information.setName(rs.getString("pri.name"));
				information.setSecondName(rs.getString("pri.second_name"));
				information.setThirdName(rs.getString("pri.third_name"));
				information.setParticipationFileName(rs.getString("pri.participation_pdf_file_name"));
				information.setParticipationName(rs.getString("pri.participation_name"));
				information.setPhone(rs.getString("pri.phone"));
				information.setInformationAccount(account);
				information.setOcupation(ocupation);
				information.setUniversity(university);
				information.setParticipation(participation);
				
				return information;
			}
		});
		return resultados;
	}

	@Override
	public ParticipationRegisterInformation findParticipationRegisterInformationByToken(
			String token) {
		String sql = "select ";
		sql = sql +		"pri.phone, p.name, pri.participation_pdf_file_name, pri.participation_name, pri.email, ia.password, pri.name, pri.second_name, pri.third_name, o.name, u.name, pri.participation_pdf_file ";
		sql = sql +	"from ";
		sql = sql + 	"participation_register_information pri, ocupation o, university u, information_account ia, participation p ";
		sql = sql +	"where ";
		sql = sql +		"p.id = pri.id_participation and o.id = pri.id_ocupation and u.id = pri.id_university and ia.email = pri.email and ia.token = ?";
		
		try {
			ParticipationRegisterInformation resultado = this.queryForObject(sql,
				new Object[] { token },
				new RowMapper<ParticipationRegisterInformation>() {
					@Override
					public ParticipationRegisterInformation mapRow(ResultSet rs,
							int rowNum) throws SQLException {
	
						InformationAccount account = new InformationAccount();
						account.setEmail(rs.getString("pri.email"));
						account.setPassword(rs.getString("ia.password"));
						
						University university = new University();
						university.setName(rs.getString("u.name"));
						
						Ocupation ocupation = new Ocupation();
						ocupation.setName(rs.getString("o.name"));
						
						ParticipationRegisterInformation information = new ParticipationRegisterInformation();
						information.setName(rs.getString("pri.name"));
						information.setSecondName(rs.getString("pri.second_name"));
						information.setThirdName(rs.getString("pri.third_name"));
						information.setParticipationFile(rs.getBytes("pri.participation_pdf_file"));
						information.setParticipationName(rs.getString("pri.participation_name"));
						information.setPhone(rs.getString("pri.phone"));
						information.setInformationAccount(account);
						information.setUniversity(university);
						information.setOcupation(ocupation);
						
						return information;
					}
				});
			return resultado;
		} catch (EmptyResultDataAccessException accessException) {
			return null;
		}
	}

	@Override
	public List<ParticipationRegisterInformation> findParticipationRegisterInformationByParamSearch(
			String searchParameter) {
		searchParameter = "%" + searchParameter + "%";		
		String sql = "select ";
		sql = sql +		"pri.phone, p.name, pri.participation_pdf_file_name, pri.participation_name, pri.email, ia.password, ia.token, pri.name, pri.second_name, pri.third_name, o.name, u.name ";
		sql = sql + "from ";
		sql = sql + 	"participation_register_information pri, ocupation o, university u, information_account ia, participation p ";
		sql = sql + "where ";
		sql = sql + 	"p.id = pri.id_participation and o.id = pri.id_ocupation and u.id = pri.id_university and ia.email = pri.email and (ia.email like ? or pri.name like ? or pri.second_name like ? or pri.third_name like ?) order by pri.name";
		
		List<ParticipationRegisterInformation> resultados = this.query(
				sql, 
				new Object[]{searchParameter, searchParameter, searchParameter, searchParameter}, 
				new RowMapper<ParticipationRegisterInformation>() {
			@Override
			public ParticipationRegisterInformation mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Ocupation ocupation = new Ocupation();
				ocupation.setName(rs.getString("o.name"));
				
				University university = new University();
				university.setName(rs.getString("u.name"));
				
				Participation participation = new Participation();
				participation.setName(rs.getString("p.name"));
				
				InformationAccount account = new InformationAccount();
				account.setEmail(rs.getString("pri.email"));
				account.setToken(rs.getString("ia.token"));								
				
				ParticipationRegisterInformation information = new ParticipationRegisterInformation();
				information.setName(rs.getString("pri.name"));
				information.setSecondName(rs.getString("pri.second_name"));
				information.setThirdName(rs.getString("pri.third_name"));
				information.setParticipationFileName(rs.getString("pri.participation_pdf_file_name"));
				information.setParticipationName(rs.getString("pri.participation_name"));
				information.setPhone(rs.getString("pri.phone"));
				information.setInformationAccount(account);
				information.setOcupation(ocupation);
				information.setUniversity(university);
				information.setParticipation(participation);
				
				return information;
			}
		});
		return resultados;
	}
	
	
}
