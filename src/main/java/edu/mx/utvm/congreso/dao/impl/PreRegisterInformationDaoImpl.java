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

import edu.mx.utvm.congreso.dao.IPreRegisterInformationDao;
import edu.mx.utvm.congreso.dominio.InformationAccount;
import edu.mx.utvm.congreso.dominio.Ocupation;
import edu.mx.utvm.congreso.dominio.PreRegisterInformation;
import edu.mx.utvm.congreso.dominio.University;
import edu.mx.utvm.congreso.dominio.UserRole;
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
				"preregister_information(EMAIL, NAME, SECOND_NAME, THIRD_NAME, ID_UNIVERSITY, ID_OCUPATION) " +
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
	public void createCapture(PreRegisterInformation newInstance) {
		this.update(
				"INSERT INTO " +
				"preregister_information(EMAIL, NAME, SECOND_NAME, THIRD_NAME, ID_UNIVERSITY, ID_OCUPATION, PAYMENT_STATUS) " +
				"VALUES(?,?,?,?,?,?,?)",
				new Object[] { 
					newInstance.getInformationAccount().getEmail(),
					newInstance.getName(),
					newInstance.getSecondName(),
					newInstance.getThirdName(),
					newInstance.getUniversity().getId(),
					newInstance.getOcupation().getId(),
					"PAGADO"
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
		sql = sql + 	"ia.token, ia.password, pi.email, pi.name, pi.second_name, pi.third_name, o.id, o.name, u.id, u.name, pi.payment_status ";
		sql = sql + "from ";
		sql = sql + 	"preregister_information pi, ocupation o, university u, information_account ia ";
		sql = sql + "where ";
		sql = sql + 	"ia.enabled = 1 and o.id = pi.id_ocupation and u.id = pi.id_university and ia.email = pi.email order by pi.name";
		List<PreRegisterInformation> resultados = this.query(sql, new RowMapper<PreRegisterInformation>() {
			@Override
			public PreRegisterInformation mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Ocupation ocupation = new Ocupation();
				ocupation.setName(rs.getString("o.name"));
				ocupation.setId(rs.getInt("o.id"));
				
				University university = new University();
				university.setName(rs.getString("u.name"));
				university.setId(rs.getInt("u.id"));
				
				InformationAccount account = new InformationAccount();
				account.setEmail(rs.getString("pi.email"));
				account.setToken(rs.getString("ia.token"));
				
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

	@Override
	public boolean getPaymentStatus(String token) {
		String queryForObject = this
				.queryForObject(
						"SELECT PI.PAYMENT_STATUS FROM preregister_information PI, information_account IA WHERE IA.TOKEN = ? AND PI.EMAIL = IA.EMAIL",
						String.class, new Object[]{token});
		if(queryForObject == null){
			return false;
		}else if(queryForObject.equals("PAGADO")){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public void changePaymentStatus(boolean status, String token) {
		String paymenStatus = status?"PAGADO":"NO_PAGADO";		
		this.update(
			"UPDATE " +
			"preregister_information SET" +
			" PAYMENT_STATUS = ? WHERE EMAIL = (SELECT EMAIL FROM information_account WHERE TOKEN = ?)",
			new Object[] { 
				paymenStatus,
				token
			}
		);
	}

	@Override
	public PreRegisterInformation findPreRegisterInformationByToken(String token) {		
	    String sql = "select ";
	    sql = sql + 	"pi.email, ia.password, pi.name, pi.second_name, pi.third_name, o.name, u.name ";
	    sql = sql + "from ";
	    sql = sql + 	"preregister_information pi, ocupation o, university u, information_account ia ";
	    sql = sql + "where ";
	    sql = sql + 	"o.id = pi.id_ocupation and u.id = pi.id_university and ia.email = pi.email and ia.token = ?";
		try {
			PreRegisterInformation resultado = this.queryForObject(sql,
					new Object[] { token },
					new RowMapper<PreRegisterInformation>() {
						@Override
						public PreRegisterInformation mapRow(ResultSet rs,
								int rowNum) throws SQLException {

							InformationAccount account = new InformationAccount();
							account.setEmail(rs.getString("pi.email"));
							account.setPassword(rs.getString("ia.password"));
							
							University university = new University();
							university.setName(rs.getString("u.name"));
							
							Ocupation ocupation = new Ocupation();
							ocupation.setName(rs.getString("o.name"));
							
							UserRole userRole = new UserRole();
							userRole.setUserId(account.getEmail());
							
							PreRegisterInformation information = new PreRegisterInformation();
							information.setName(rs.getString("pi.name"));
							information.setSecondName(rs.getString("pi.second_name"));
							information.setThirdName(rs.getString("pi.third_name"));

							information.setInformationAccount(account);
							information.setUniversity(university);
							information.setOcupation(ocupation);
							information.setUserRole(userRole);
							
							return information;
						}
					});
			return resultado;
		} catch (EmptyResultDataAccessException accessException) {
			return null;
		}
	}

	@Override
	public List<PreRegisterInformation> findAllPreRegistersByParamSearch(String searchParameter) {
		searchParameter = "%" + searchParameter + "%";
		
		String sql = "select ";		
		sql = sql + 	"ia.token, ia.password, pi.email, pi.name, pi.second_name, pi.third_name, o.id, o.name, u.id, u.name, pi.payment_status ";
		sql = sql + "from ";
		sql = sql + 	"preregister_information pi, ocupation o, university u, information_account ia ";
		sql = sql + "where ";
		sql = sql + 	"ia.enabled = 1 and o.id = pi.id_ocupation and u.id = pi.id_university and ia.email = pi.email and (ia.email like ? or ";
		sql = sql + 	"pi.name like ? or pi.second_name like ? or pi.third_name like ?)  order by pi.name";
		
		
		List<PreRegisterInformation> resultados = this.query(
				sql, 
				new Object[]{searchParameter, searchParameter, searchParameter, searchParameter}, 
				new RowMapper<PreRegisterInformation>() {
			@Override
			public PreRegisterInformation mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Ocupation ocupation = new Ocupation();
				ocupation.setId(rs.getInt("o.id"));
				ocupation.setName(rs.getString("o.name"));
				
				University university = new University();
				university.setId(rs.getInt("u.id"));
				university.setName(rs.getString("u.name"));
				
				InformationAccount account = new InformationAccount();
				account.setEmail(rs.getString("pi.email"));
				account.setToken(rs.getString("ia.token"));
				
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
	
	@Override
	public PreRegisterInformation findPreRegisterInformationByUserName(String userName) {		
	    String sql = "select ";
	    sql = sql + 	"ia.token, pi.email, ia.password, pi.name, pi.second_name, pi.third_name, o.name, u.name ";
	    sql = sql + "from ";
	    sql = sql + 	"preregister_information pi, ocupation o, university u, information_account ia ";
	    sql = sql + "where ";
	    sql = sql + 	"o.id = pi.id_ocupation and u.id = pi.id_university and pi.email = ia.email and ia.email = ?";
		try {
			PreRegisterInformation resultado = this.queryForObject(sql,
					new Object[] { userName },
					new RowMapper<PreRegisterInformation>() {
						@Override
						public PreRegisterInformation mapRow(ResultSet rs,
								int rowNum) throws SQLException {

							InformationAccount account = new InformationAccount();
							account.setEmail(rs.getString("pi.email"));
							account.setPassword(rs.getString("ia.password"));
							account.setToken(rs.getString("ia.token"));
							
							University university = new University();
							university.setName(rs.getString("u.name"));
							
							Ocupation ocupation = new Ocupation();
							ocupation.setName(rs.getString("o.name"));
							
							UserRole userRole = new UserRole();
							userRole.setUserId(account.getEmail());
							
							PreRegisterInformation information = new PreRegisterInformation();
							information.setName(rs.getString("pi.name"));
							information.setSecondName(rs.getString("pi.second_name"));
							information.setThirdName(rs.getString("pi.third_name"));

							information.setInformationAccount(account);
							information.setUniversity(university);
							information.setOcupation(ocupation);
							information.setUserRole(userRole);
							
							return information;
						}
					});
			return resultado;
		} catch (EmptyResultDataAccessException accessException) {
			return null;
		}
	}
	
	@Override
	public void updateName(PreRegisterInformation preRegisterInformation, String email) {	
		this.update(
			"UPDATE " +
			"preregister_information SET" +
			" name = ?, second_name = ?, third_name = ? WHERE email = ?",
			new Object[] { 
				preRegisterInformation.getName(),
				preRegisterInformation.getSecondName(),
				preRegisterInformation.getThirdName(),
				email
			}
		);
	}
}
