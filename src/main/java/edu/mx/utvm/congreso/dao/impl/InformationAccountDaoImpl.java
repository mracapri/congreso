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

import edu.mx.utvm.congreso.dao.IInformationAccountDao;
import edu.mx.utvm.congreso.dominio.InformationAccount;
@Repository
public class InformationAccountDaoImpl extends JdbcTemplate implements IInformationAccountDao{
	
	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	public void create(InformationAccount newInstance) {
		this.update(
			"INSERT INTO information_account(EMAIL, PASSWORD, TOKEN, REFERENCE_KEY, ENABLED) VALUES(?,?,?,?,?)",
			new Object[] { 
					newInstance.getEmail(),
					newInstance.getPassword(), 
					newInstance.getToken(),
					newInstance.getReferenceKey(),
					newInstance.getEnabled()
			}
		);
	}

	@Override
	public InformationAccount read(Integer id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void update(InformationAccount transientObject) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public void delete(InformationAccount persistentObject) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<InformationAccount> findAll() {
		throw new UnsupportedOperationException();
	}

	@Override
	public InformationAccount findAccountWithEmail(String email) {
	    String sql = "SELECT EMAIL FROM information_account WHERE EMAIL = ?";	    
		try {
			InformationAccount resultado = this.queryForObject(sql,
					new Object[] { email },
					new RowMapper<InformationAccount>() {
						@Override
						public InformationAccount mapRow(ResultSet rs,
								int rowNum) throws SQLException {
							InformationAccount informationAccount = new InformationAccount();
							return informationAccount;
						}
					});
			return resultado;
		} catch (EmptyResultDataAccessException accessException) {
			return null;
		}
	}

	@Override
	public void confirmToken(String token) {
		this.update(
			"UPDATE information_account SET ENABLED = 1 WHERE TOKEN = ?",
			new Object[] {
				token
			}
		);
	}
}
