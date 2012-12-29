package edu.mx.utvm.congreso.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
				"FISCAL_INFORMATION(EMAIL, FISCAL_NAME, RFC, ADDRESS) " +
				"VALUES(?,?,?,?)",
				new Object[] { 
					newInstance.getEmail(),
					newInstance.getFiscalName(),
					newInstance.getRfc(),
					newInstance.getAddress()
				});
	}

	@Override
	public FiscalRegisterInformation read(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(FiscalRegisterInformation transientObject) {
		// TODO Auto-generated method stub
		
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
