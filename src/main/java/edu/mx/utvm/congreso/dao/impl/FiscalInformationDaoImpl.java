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

import edu.mx.utvm.congreso.dao.IFiscalInformationDao;
import edu.mx.utvm.congreso.dominio.FiscalRegisterInformation;
@Repository
public class FiscalInformationDaoImpl extends JdbcTemplate implements IFiscalInformationDao{
	
	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	public void create(FiscalRegisterInformation newInstance) {
		this.update(
				"INSERT INTO " +
				"fiscal_information(EMAIL, FISCAL_NAME, RFC, ADDRESS) " +
				"VALUES(?,?,?,?)",
				new Object[] { 
					newInstance.getEmail(),
					newInstance.getFiscalName(),
					newInstance.getRfc(),
					newInstance.getAddress()
				});
	}

	@Override
	public FiscalRegisterInformation read(String email) {
	    String sql = "SELECT EMAIL, FISCAL_NAME, RFC, ADDRESS FROM fiscal_information WHERE EMAIL = ?";	    
		try {
			FiscalRegisterInformation resultado = this.queryForObject(sql,
					new Object[] { email },
					new RowMapper<FiscalRegisterInformation>() {
						@Override
						public FiscalRegisterInformation mapRow(ResultSet rs,
								int rowNum) throws SQLException {
							FiscalRegisterInformation fiscalRegisterInformation = new FiscalRegisterInformation();
							fiscalRegisterInformation.setAddress(rs.getString("ADDRESS"));
							fiscalRegisterInformation.setEmail(rs.getString("EMAIL"));
							fiscalRegisterInformation.setFiscalName(rs.getString("FISCAL_NAME"));
							fiscalRegisterInformation.setRfc(rs.getString("RFC"));
							return fiscalRegisterInformation;
						}
					});
			return resultado;
		} catch (EmptyResultDataAccessException accessException) {
			return null;
		}
	}

	@Override
	public void update(FiscalRegisterInformation transientObject) {
		this.update(
			"UPDATE " +
			"fiscal_information SET FISCAL_NAME = ?, RFC = ?, ADDRESS = ? " +
			"WHERE EMAIL = ?",
			new Object[] { 
				transientObject.getFiscalName(),
				transientObject.getRfc(),
				transientObject.getAddress(),
				transientObject.getEmail()
			});
	}

	@Override
	public void delete(FiscalRegisterInformation persistentObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<FiscalRegisterInformation> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


}
