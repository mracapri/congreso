package edu.mx.utvm.congreso.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.mx.utvm.congreso.dao.IOcupationDao;
import edu.mx.utvm.congreso.dominio.Ocupation;
@Repository
public class OcupationDaoImpl extends JdbcTemplate implements IOcupationDao{

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	@Override
	public void create(Ocupation newInstance) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public Ocupation read(Integer id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void update(Ocupation transientObject) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public void delete(Ocupation persistentObject) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Ocupation> findAll() {
		String sql = "SELECT * FROM ocupation";
		List<Ocupation> result = this.query(sql, new RowMapper<Ocupation>() {
			@Override
			public Ocupation mapRow(ResultSet rs, int rowNum) throws SQLException {
				Ocupation ocupation = new Ocupation();
				ocupation.setId(rs.getInt("ID"));
				ocupation.setName(rs.getString("NAME"));
				return ocupation;
			}
		});
		return result;
	}

}
