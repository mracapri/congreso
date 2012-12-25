package edu.mx.utvm.congreso.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import edu.mx.utvm.congreso.dao.IUniversityDao;
import edu.mx.utvm.congreso.dominio.University;

public class UniversityDaoImpl extends JdbcTemplate implements IUniversityDao{

	@Override
	public void create(University newInstance) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public University read(Integer id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void update(University transientObject) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public void delete(University persistentObject) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<University> findAll() {
		String sql = "SELECT * FROM UNIVERSITY";
		List<University> result = this.query(sql, new RowMapper<University>() {
			@Override
			public University mapRow(ResultSet rs, int rowNum) throws SQLException {
				University university = new University();
				university.setId(rs.getInt("ID"));
				university.setName(rs.getString("NAME"));
				return university;
			}
		});
		return result;
	}

}
